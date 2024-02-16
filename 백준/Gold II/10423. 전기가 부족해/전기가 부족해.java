import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int from;
	int to;
	int weight;

	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}

public class Main {
	static int V;
	static boolean[] installed;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 부모노드 초기화
		p = new int[V + 1];
		for (int i = 0; i <= V; i++)
			p[i] = i;

		// 발전소가 설치된 노드 표시
		installed = new boolean[V + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			installed[Integer.parseInt(st.nextToken())] = true;

		// 간선 정보 입력
		ArrayList<Node> graph = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.add(new Node(from, to, weight));
		}

		// 크루스칼 알고리즘 적용
		Collections.sort(graph);
		int sum = 0;
		for (Node n : graph) {
			int from = n.from;
			int to = n.to;
			int weight = n.weight;

			int pfrom = find(from);
			int pto = find(to);

			if (pfrom == pto)
				continue;

			if (installed[pfrom] && installed[pto])
				continue;
			
			sum += weight;
			union(from, to);
		}
		
		System.out.print(sum);
	}

	public static int find(int x) {
		if (x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}

	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {
			if (installed[py] && !installed[px])
				p[px] = py;
			else {
				p[py] = px;
			}
		}
	}
}
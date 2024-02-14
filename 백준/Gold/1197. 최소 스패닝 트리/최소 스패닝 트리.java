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
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Node> graph = new ArrayList<>();

		p = new int[V + 1];
		for (int v = 0; v <= V; v++)
			p[v] = v;

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.add(new Node(a, b, weight));
		}

		Collections.sort(graph);

		int sum = 0;

		for (Node n : graph) {
			int a = n.from;
			int b = n.to;
			int weight = n.weight;
			
			if (find(a) == find(b))
				continue;

			sum += weight;
			union(a, b);
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

		if (px != py)
			p[py] = px;
	}
}
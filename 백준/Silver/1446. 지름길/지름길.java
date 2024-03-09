import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	// 고속도로의 길이
	static int D;
	// i까지 걸리는 최소 거리
	static int dist[];
	// 지름길
	static ArrayList<ArrayList<Node>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		dist = new int[10001];
		list = new ArrayList<>();
		for (int i = 0; i < 10001; i++) {
			dist[i] = i;
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, weight));
		}
		
		dijkstra(0);
		
		System.out.print(dist[D]);

	}

	public static void dijkstra(int start) {
		if (start > D)
			return;

		// 거리 갱싱
		if (dist[start + 1] > dist[start] + 1)
			dist[start + 1] = dist[start] + 1;

		for (Node n : list.get(start)) {
			if (dist[start] + n.weight < dist[n.to])
				dist[n.to] = dist[start] + n.weight;
		}

		dijkstra(start + 1);
	}
}
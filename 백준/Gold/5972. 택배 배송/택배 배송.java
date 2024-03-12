import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));
		}
		
		dijkstra();
		
		System.out.print(dist[N]);
	}

	public static void dijkstra() {
		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(1, 0));
		dist[1] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();
			
			if(!visit[now.to])
				visit[now.to] = true;
			else
				continue;

			for (int i = 0; i < graph.get(now.to).size(); i++) {
				Node next = graph.get(now.to).get(i);

				if (dist[now.to] + next.weight < dist[next.to]) {
					dist[next.to] = dist[now.to] + next.weight;
					q.add(new Node(next.to, dist[next.to]));
				}
			}
		}

	}
}

class Node implements Comparable<Node> {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}
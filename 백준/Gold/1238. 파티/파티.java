import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, X;
	public static ArrayList<ArrayList<Edge>> graph;
	public static int[] toXDist;
	public static int[] fromXDist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Edge(to, time));
		}

		// 목적지 X에서 각 마을로 가는 최단 거리 계산
		toXDist = dijkstra(X);

		// 각 마을에서 목적지 X로 가는 최단 거리 계산
		fromXDist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			fromXDist[i] = dijkstra(i)[X];
		}

		// 각 학생이 X로 가는데 걸리는 시간 중 최대값 찾기
		int maxTime = 0;
		for (int i = 1; i <= N; i++) {
			maxTime = Math.max(maxTime, toXDist[i] + fromXDist[i]);
		}

		System.out.println(maxTime);
	}

	public static int[] dijkstra(int start) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		boolean[] visit = new boolean[N + 1];

		q.add(new Edge(start, 0));

		while (!q.isEmpty()) {
			Edge now = q.poll();

			if (visit[now.to])
				continue;
			visit[now.to] = true;

			for (Edge next : graph.get(now.to)) {
				if (dist[next.to] > dist[now.to] + next.time) {
					dist[next.to] = dist[now.to] + next.time;
					q.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		return dist;
	}
}

class Edge implements Comparable<Edge> {
	int to;
	int time;

	public Edge(int to, int time) {
		this.to = to;
		this.time = time;
	}

	@Override
	public int compareTo(Edge e) {
		return Integer.compare(this.time, e.time);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<ArrayList<Bridge>> graph;
	public static int depart, arrive;
	public static boolean[] visit;
	public static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		int left = 0;
		int right = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Bridge(to, weight));
			graph.get(to).add(new Bridge(from, weight));

			right = Math.max(right, weight);
		}

		st = new StringTokenizer(br.readLine(), " ");
		depart = Integer.parseInt(st.nextToken());
		arrive = Integer.parseInt(st.nextToken());

		while (left <= right) {
			int mid = (left + right) / 2;
			result = -1;
			visit = new boolean[N + 1];

			dfs(depart, mid);

			// 현재 탐색 값으로 이동이 가능한 경우
			if (result != -1)
				left = mid + 1;
			// 이동이 불가능한 경우
			else
				right = mid - 1;
		}
		
		System.out.println(right);
	}

	public static void dfs(int now, int weight) {
		// 도착 섬에 다다른 경우
		if (now == arrive) {
			result = now;
			return;
		}

		visit[now] = true;

		// 현재 탐색중인 weight 값을 다음 다리가 감당할 수 있는지 체크
		for (Bridge b : graph.get(now)) {
			if (!visit[b.to] && weight <= b.weight)
				dfs(b.to, weight);
		}
	}
}

class Bridge {
	int to;
	int weight;

	public Bridge(int t, int w) {
		this.to = t;
		this.weight = w;
	}
}

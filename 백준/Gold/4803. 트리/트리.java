import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = 1;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++)
				graph.add(new ArrayList<>());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			// 트리 개수 카운트
			visit = new boolean[N + 1];
			int tree = 0;
			for (int i = 1; i <= N; i++) {
				if (!visit[i])
					tree += check(i);
			}

			sb.append("Case " + tc + ": ");
			if (tree == 0)
				sb.append("No trees.\n");
			else if (tree == 1)
				sb.append("There is one tree.\n");
			else
				sb.append("A forest of " + tree + " trees.\n");

			tc++;
		}

		System.out.print(sb.toString());
	}

	// 노드의 개수가 N일 때 간선의 개수가 N - 1이라면, 트리로 판정
	public static int check(int startNode) {
		Queue<Integer> q = new LinkedList<>();
		int node = 0;
		int edge = 0;

		q.add(startNode);

		while (!q.isEmpty()) {
			int now = q.poll();

			if (!visit[now]) {
				visit[now] = true;
				node++;

				for (int next : graph.get(now)) {
					edge++;
					if (!visit[next])
						q.add(next);
				}
			}
		}

		return node - 1 == edge / 2 ? 1 : 0;
	}
}

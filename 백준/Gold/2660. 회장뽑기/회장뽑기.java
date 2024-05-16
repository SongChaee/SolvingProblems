import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static ArrayList<ArrayList<Integer>> friends;
	public static int[][] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		friends = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			friends.add(new ArrayList<>());

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1)
				break;

			friends.get(a).add(b);
			friends.get(b).add(a);
		}

		// i번 사람이 모든 사람들에 대해서 점수를 측정하여 계산
		score = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			Arrays.fill(score[i], 50);
		for (int i = 1; i <= N; i++)
			getScore(i);

		int[] rank = new int[N + 1];
		int minscore = 50;
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				max = Math.max(max, score[i][j]);
			}
			rank[i] = max;
			minscore = Math.min(minscore, rank[i]);
		}

		StringBuilder sb = new StringBuilder();

		Queue<Integer> winner = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			if (rank[i] == minscore)
				winner.add(i);

		sb.append(minscore).append(" ").append(winner.size()).append("\n");
		while (!winner.isEmpty())
			sb.append(winner.poll()).append(" ");

		System.out.println(sb.toString());
	}

	public static void getScore(int idx) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];

		q.add(new int[] { idx, 0 });
		visit[idx] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int next : friends.get(now[0])) {
				if (!visit[next]) {
					q.add(new int[] { next, now[1] + 1 });
					score[idx][next] = Math.min(score[idx][next], now[1] + 1);
					score[next][idx] = score[idx][next];
					visit[next] = true;
				}
			}
		}
	}
}

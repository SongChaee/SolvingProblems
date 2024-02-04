import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Queue<Integer> q;
		boolean[] visit;
		String[] ans;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			q = new LinkedList<>();
			visit = new boolean[10000];
			ans = new String[10000];

			q.add(from);
			visit[from] = true;
			Arrays.fill(ans, "");

			while (!q.isEmpty() && !visit[to]) {
				int check = q.poll();

				int D = (check * 2) % 10000;
				int S = check == 0 ? 9999 : check - 1;
				int L = (check % 1000) * 10 + check / 1000;
				int R = (check % 10) * 1000 + check / 10;

				if (!visit[D]) {
					q.add(D);
					visit[D] = true;
					ans[D] = ans[check] + "D";
				}

				if (!visit[S]) {
					q.add(S);
					visit[S] = true;
					ans[S] = ans[check] + "S";
				}

				if (!visit[L]) {
					q.add(L);
					visit[L] = true;
					ans[L] = ans[check] + "L";
				}

				if (!visit[R]) {
					q.add(R);
					visit[R] = true;
					ans[R] = ans[check] + "R";
				}
			}

			sb.append(ans[to]).append("\n");
		}

		System.out.print(sb.toString());
	}
}
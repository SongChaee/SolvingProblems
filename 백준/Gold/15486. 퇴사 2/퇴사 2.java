import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] days = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			days[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());

		}

		int[] dp = new int[N + 1];
		int tmp = -1;

		for (int i = 0; i <= N; i++) {
			if (tmp < dp[i])
				tmp = dp[i];

			int next = i + days[i];
			if (next < N + 1)
				dp[next] = Math.max(dp[next], tmp + profits[i]);
		}

		System.out.println(dp[N]);
	}
}

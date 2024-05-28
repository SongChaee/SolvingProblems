import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] isVIP = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			isVIP[num] = true;
		}

		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			if (isVIP[i] || isVIP[i - 1]) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		System.out.println(dp[N]);
	}
}

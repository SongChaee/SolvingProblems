import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		// idx 초에 자두가 떨어지는 나무의 번호
		int[] tree = new int[T + 1];
		for (int i = 1; i <= T; i++)
			tree[i] = Integer.parseInt(br.readLine());

		// 현재 위치
		int pos = 1;
		// t초에 w번의 이동으로 얻을 수 있는 자두의 최대 개수 구하는 배열
		int[][] dp = new int[T + 1][W + 1];
		int ans = 0;

		// 모든 시간에 대해 수행
		for (int t = 1; t <= T; t++) {
			int target = tree[t];

			// 모든 이동 횟수를 고려
			for (int w = 0; w <= W; w++) {
				// 이동횟수가 0인 경우
				if (w == 0) {
					pos = 1;
					if (target == pos)
						dp[t][w] = dp[t - 1][w] + 1;
					else
						dp[t][w] = dp[t - 1][w];
				}
				// 이동을 한번이라도 한 경우
				else {
					// 이동횟수가 짝수인 경우
					if (w % 2 == 0) {
						pos = 1;
						// 현재 위치에 자두가 떨어지는 경우
						// 1초 전에 w번 만큼 움직였을 때의 자두 수에서 하나를 더 받을 때와
						// 이번에는 자두를 받지 않는, 1초 전에 2번 나무에서 있었던 때 중 큰 값을 저장
						if (target == pos)
							dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
						// 2번 위치에 자두가 떨어지는 경우
						// 1초 전에 1번 위치에 있어서 1회 이동 후 2번 위치에서 이동하여 자두는 받을 때와
						// 이번에는 자두를 받지 않는, 1초 전 1번 나무에 있었던 때 중 큰 값을 저장
						else
							dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
					}
					// 이동 횟수가 홀수인 경우
					else {
						pos = 2;
						if (target == pos)
							dp[t][w] = Math.max(dp[t - 1][w] + 1, dp[t - 1][w - 1]);
						else
							dp[t][w] = Math.max(dp[t - 1][w - 1] + 1, dp[t - 1][w]);
					}
				}

				ans = Math.max(ans, dp[t][w]);
			}
		}

		System.out.println(ans);
	}
}

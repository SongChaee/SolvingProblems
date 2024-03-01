import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// dp[x][y] : x 를 완성시킬 때 수식의 마지막 숫자가 y인 경우
		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		
		for(int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][1] + dp[num][2] + dp[num][3]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
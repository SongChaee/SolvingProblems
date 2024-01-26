import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		int[] number = new int[len];
		for (int i = 0; i < len; i++)
			number[i] = input.charAt(i) - '0';

		int[] dp = new int[len + 1];
		dp[0] = 1;

		for (int i = 1; i <= len; i++) {
			if (number[i - 1] >= 1 && number[i - 1] <= 9) {
				dp[i] += dp[i - 1];
				dp[i] %= 1000000;
			}

			if (i == 1)
				continue;
			if (number[i - 2] == 0)
				continue;
			
			int num = number[i - 2] * 10 + number[i - 1];
			if(num >= 10 && num <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= 1000000;
			}
		}

		System.out.print(dp[len]);
	}
}
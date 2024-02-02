import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] price = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int n = 1; n <= N; n++)
			price[n] = Integer.parseInt(st.nextToken());
		
		for(int n = 1; n <= N; n++)
			for(int i = 1; i <= n; i++)
				dp[n] = Math.max(dp[n], dp[n-i] + price[i]);
		
		System.out.print(dp[N]);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N][3];
		int[][] dp = new int[N][3];
		
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 3; i++)
				price[n][i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		// 첫번째 집 색상 결정
		for(int first = 0; first < 3; first++) {
			// 첫번째 집 색상을 제외한 다른 색상 초기화
			for(int i = 0; i < 3; i++) {
				if(i == first) dp[0][i] = price[0][i];
				else dp[0][i] = 1000000;
			}
			
			// 두번째 집부터 N번째 집까지 색상 결정
			for(int idx = 1; idx < N; idx++) {
				dp[idx][0] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + price[idx][0];
				dp[idx][1] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + price[idx][1];
				dp[idx][2] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + price[idx][2];
			}
			
			// 최솟값 비교
			for(int last = 0; last < 3; last++)
				if(first != last)
					min = Math.min(min, dp[N-1][last]);
		}
		
		System.out.print(min);
	}
}
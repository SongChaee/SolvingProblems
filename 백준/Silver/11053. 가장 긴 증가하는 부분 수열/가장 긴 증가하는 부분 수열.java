import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr, dp;
	public static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			dp[n] = 1;
		}
		
		max = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++)
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i],  dp[j] + 1);
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}

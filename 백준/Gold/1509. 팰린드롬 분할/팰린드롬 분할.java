import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] string;
	static int len;
	static boolean[][] isPalin;
	static int[] dp;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		string = br.readLine().toCharArray();
		len = string.length;
		isPalin = new boolean[len + 1][len + 1];
		
		dp = new int[len + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		checkPalin();
		findMin();
		
		System.out.print(dp[len]);
	}
	
	public static void findMin() {
		for(int i = 1; i <= len; i++) {
			for(int j = 1; j <= i; j++) {
				if(isPalin[j][i])
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
			}
		}
	}
	
	public static void checkPalin() {
		for(int start = 1; start <= len; start++) {
			for(int end = start; end <= len; end++) {
				boolean flag = true;
				int s = start - 1;
				int e = end - 1;
				
				while(s <= e) {
					if(string[s++] != string[e--]) {
						flag = false;
						break;
					}
				}
				
				if(flag)
					isPalin[start][end] = true;
			}
		}
	}
}
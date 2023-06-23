import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] stock = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0; n < N; n++)
				stock[n] = Integer.parseInt(st.nextToken());
			
			long ans = 0;
			int max = stock[N-1];
			for(int i = N-2; i >= 0; i--) {
				if(stock[i] > max)
					max = stock[i];
				ans += max - stock[i];
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] coin = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				coin[i] = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(br.readLine());
			
			int[] arr = new int[target + 1];
			arr[0] = 1;
			for(int c : coin) {
				for(int money = c; money <= target; money++)
					arr[money] += arr[money - c];
			}
			
			sb.append(arr[target]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
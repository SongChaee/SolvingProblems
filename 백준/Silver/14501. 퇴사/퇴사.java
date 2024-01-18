import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] days;
	public static int[] pros;
	public static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		days = new int[N];
		pros = new int[N];
		
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			days[n] = Integer.parseInt(st.nextToken());
			pros[n] = Integer.parseInt(st.nextToken());
		}
		
		work(0, 0);
		
		System.out.print(max);
	}
	
	public static void work(int idx, int profit) {
		if(idx >= N) {
			max = Math.max(max, profit);
			return;
		}
		
		// idx 번째 날의 상담을 진행하지 않는 경우
		work(idx + 1, profit);
		
		// idx 번째 날의 상담을 진행하는 경우
		if(idx + days[idx] > N) {
			max = Math.max(max, profit);
			return;
		}
		else {
			work(idx + days[idx], profit + pros[idx]);			
		}
	}
}
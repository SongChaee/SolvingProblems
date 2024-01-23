import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int idx = 0; idx < N; idx++) {
			int sum = arr[idx];
			if(sum == M) {
				ans++;
				continue;
			}
			for(int next = idx + 1; next < N; next++) {
				sum += arr[next];
				if(sum == M) {
					ans++;
					break;
				}
				else if(sum > M) break;
			}
		}
		
		System.out.print(ans);
	}
}
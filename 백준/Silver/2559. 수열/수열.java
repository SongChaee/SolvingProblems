import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		for(int idx = 0; idx <= N-K; idx++) {
			int sum = arr[idx];
			for(int k = 1; k < K; k++) {
				sum += arr[idx + k];
			}
			max = Math.max(max, sum);
		}
		
		System.out.print(max);
	}
}
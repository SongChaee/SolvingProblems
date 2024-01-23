import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i < N; i++)
			arr[i] = arr[i - 2] + arr[i - 1];
		
		System.out.print(arr[N-1]);
	}
}
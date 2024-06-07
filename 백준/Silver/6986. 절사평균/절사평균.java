import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		double[] arr = new double[N];

		for (int i = 0; i < N; i++)
			arr[i] = Double.parseDouble(br.readLine());

		Arrays.sort(arr);

		double sum = 0;
		for (int i = K; i < N - K; i++)
			sum += arr[i];

		System.out.println(String.format("%.2f", sum / (N - K * 2) + 1e-8));

		for (int i = 0; i < K; i++) {
			sum += arr[K];
			sum += arr[N - K - 1];
		}

		System.out.println(String.format("%.2f", sum / N + 1e-8));

	}
}

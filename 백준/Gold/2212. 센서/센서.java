import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if (K >= N) {
			System.out.println("0");
		} else {
			int[] sensor = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++)
				sensor[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(sensor);

			int[] gap = new int[N - 1];
			for (int i = 0; i < N - 1; i++)
				gap[i] = sensor[i + 1] - sensor[i];

			Arrays.sort(gap);

			int ans = 0;
			for (int i = 0; i < N - K; i++)
				ans += gap[i];

			System.out.println(ans);
		}
	}
}

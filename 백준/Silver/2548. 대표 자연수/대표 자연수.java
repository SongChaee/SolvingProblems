import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[10001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			cnt[Integer.parseInt(st.nextToken())]++;

		int tmp = 0;
		int mid = (n - 1) / 2;

		for (int i = 1; i <= 10000; i++) {
			tmp += cnt[i];

			if (tmp > mid) {
				System.out.println(i);
				return;
			}
		}
	}
}

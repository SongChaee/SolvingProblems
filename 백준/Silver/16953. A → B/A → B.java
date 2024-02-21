import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int ans = 1;
		while (B != A) {
			if (B < A) {
				ans = -1;
				break;
			}

			String b = Long.toString(B);
			if (b.charAt(b.length() - 1) != '1' && B % 2 != 0) {
				ans = -1;
				break;
			}

			if (B % 2 == 0)
				B >>= 1;
			else
				B = Long.parseLong(b.substring(0, b.length() - 1));

			ans++;
		}

		System.out.print(ans);
	}

}
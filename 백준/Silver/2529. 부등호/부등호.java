import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static char[] sign;
	public static String min = "9876543210";
	public static String max = "0";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sign = new char[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			sign[i] = st.nextToken().charAt(0);

		boolean[] used = new boolean[10];
		for (int i = 0; i < 10; i++) {
			used[i] = true;
			find(1, i + "", used);
			used[i] = false;
		}

		System.out.println(max);
		System.out.println(min);
	}

	public static void find(int idx, String now, boolean[] used) {
		if (idx > N) {
			if (Long.parseLong(now) < Long.parseLong(min))
				min = now;
			if (Long.parseLong(now) > Long.parseLong(max))
				max = now;
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!used[i]) {
				if (idx == 0 || check(sign[idx - 1], now.charAt(idx - 1) - '0', i)) {
					used[i] = true;
					find(idx + 1, now + i, used);
					used[i] = false;
				}
			}
		}
	}

	public static boolean check(char op, int a, int b) {
		if (op == '<')
			return a < b;
		else
			return a > b;
	}
}

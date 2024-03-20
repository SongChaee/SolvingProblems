import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static boolean[] target;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		boolean[] init1 = new boolean[N];
		boolean[] init2 = new boolean[N];
		target = new boolean[N];

		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '1') {
				init1[i] = true;
				init2[i] = true;
			}
		}

		str = br.readLine();
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '1')
				target[i] = true;
		}

		// 첫번째 스위치를 사용하지 않은 경우
		greedy(1, init1, 0);

		// 첫번째 스위치를 사용한 경우
		greedy(1, change(0, init2), 1);

		System.out.print(ans == Integer.MAX_VALUE ? "-1" : ans);

	}

	public static void greedy(int idx, boolean[] arr, int cnt) {
		if (idx == N) {
			if (arr[N - 1] == target[N - 1])
				ans = Math.min(ans, cnt);
			return;
		}

		if (arr[idx - 1] == target[idx - 1])
			greedy(idx + 1, arr, cnt);
		else
			greedy(idx + 1, change(idx, arr), cnt + 1);
	}

	public static boolean[] change(int idx, boolean[] arr) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i >= 0 && i < N)
				arr[i] = !arr[i];
		}
		return arr;
	}
}

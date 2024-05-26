import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] score;
		if (N > 0)
			score = new int[N];
		else
			score = new int[0];

		if (N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				score[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(score);

		if (N == P && score[0] >= target) {
			System.out.println("-1");
		} else {
			int cnt = 1;

			for (int i = N - 1; i >= 0; i--) {
				if (score[i] > target)
					cnt++;
				else
					break;
			}

			if (N < P) {
				cnt = Math.min(cnt, N + 1);
			}

			System.out.println(cnt);
		}
	}
}

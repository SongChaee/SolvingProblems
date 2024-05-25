import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 1;
			int work[] = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				work[a] = b;
			}

			int tmp = work[1];

			for (int i = 2; i <= N; i++) {
				if (work[i] < tmp) {
					tmp = work[i];
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}

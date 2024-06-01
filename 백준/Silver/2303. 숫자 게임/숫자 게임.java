import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] cards = new int[N][5];
		int[] max = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++)
				cards[i][j] = Integer.parseInt(st.nextToken());

			int num = 0;
			for (int a = 0; a < 3; a++) {
				for (int b = a + 1; b < 4; b++) {
					for (int c = b + 1; c < 5; c++) {
						int tmp = cards[i][a] + cards[i][b] + cards[i][c];
						num = Math.max(num, tmp % 10);
					}
				}
			}

			max[i] = num;
		}

		int idx = 0;
		int value = max[0];
		for (int i = 1; i < N; i++) {
			if (max[i] >= value) {
				idx = i;
				value = max[i];
			}
		}

		System.out.println(idx + 1);
	}
}

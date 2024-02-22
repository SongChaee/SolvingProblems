import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] sticker;
		for (int tc = 0; tc < T; tc++) {
			int c = Integer.parseInt(br.readLine());

			sticker = new int[2][c + 1];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= c; j++)
					sticker[i][j] = Integer.parseInt(st.nextToken());
			}

			// dp를 활용한 최대 점수 계산
			// 0행 i열 스티커를 선택한 경우, 이전에 선택한 스티커는 1행에 존재
			for (int i = 2; i <= c; i++) {
				sticker[0][i] += Math.max(sticker[1][i - 1], sticker[1][i - 2]);
				sticker[1][i] += Math.max(sticker[0][i - 1], sticker[0][i - 2]);
			}
			
			sb.append(Math.max(sticker[0][c], sticker[1][c])).append("\n");
		}

		System.out.print(sb.toString());
	}
}
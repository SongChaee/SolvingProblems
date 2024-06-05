import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] dice;
	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dice = new int[N][6];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++)
			setting(1, i, 0);

		System.out.println(ans);
	}

	public static void setting(int layer, int bottom, int sum) {
		// 아랫면을 마주 보는 면
		int next = pair(bottom);

		// 옆면의 최댓값
		int max = -1;
		for (int i = 0; i < 6; i++) {
			if (i == next || i == bottom)
				continue;
			max = Math.max(max, dice[layer - 1][i]);
		}

		sum += max;

		// 마지막 주사위를 쌓은 경우
		if (layer == N) {
			ans = Math.max(ans, sum);
			return;
		}

		// 다음 주사위 쌓기
		for (int i = 0; i < 6; i++) {
			if (dice[layer - 1][next] == dice[layer][i]) {
				setting(layer + 1, i, sum);
				break;
			}
		}
	}

	// 마주보는 면의 index를 반환
	public static int pair(int idx) {
		if (idx == 0)
			return 5;
		else if (idx == 1)
			return 3;
		else if (idx == 2)
			return 4;
		else if (idx == 3)
			return 1;
		else if (idx == 4)
			return 2;
		else
			return 0;
	}
}

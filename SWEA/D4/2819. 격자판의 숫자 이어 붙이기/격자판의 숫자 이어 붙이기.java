import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] map;
	public static boolean[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			result = new boolean[10000000];

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					make(i, j, 0, map[i][j] + "");
			}

			sb.append("#" + tc + " " + count() + "\n");
		}

		System.out.print(sb.toString());
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < 10000000; i++) {
			if (result[i])
				cnt++;
		}
		return cnt;
	}

	public static void make(int x, int y, int cnt, String str) {
		if (cnt == 6) {
			result[Integer.parseInt(str)] = true;
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (OOB(nx, ny))
				continue;

			make(nx, ny, cnt + 1, str + map[nx][ny]);
		}
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= 4 || y < 0 || y >= 4)
			return true;
		return false;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		boolean[][] visit = new boolean[R][C];
		boolean[] selected = new boolean[26];

		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = tmp.charAt(j);
		}

		visit[0][0] = true;
		selected[map[0][0] - 'A'] = true;
		find(0, 0, visit, selected, 1);
		
		System.out.println(ans);

	}

	public static void find(int x, int y, boolean[][] visit, boolean[] selected, int cnt) {
		ans = Math.max(ans, cnt);

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (OOB(nx, ny))
				continue;

			if (visit[nx][ny])
				continue;
			
			if(selected[map[nx][ny] - 'A'])
				continue;
			
			visit[nx][ny] = true;
			selected[map[nx][ny] - 'A'] = true;
			find(nx, ny, visit, selected, cnt + 1);
			
			visit[nx][ny] = false;
			selected[map[nx][ny] - 'A'] = false;
		}
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return true;
		return false;
	}
}

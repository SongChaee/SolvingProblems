import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static final int RIGHT = 0;
	public static final int UP = 1;
	public static final int LEFT = 2;
	public static final int DOWN = 3;
	public static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			draw(x, y, getDir(d, g));
		}

		System.out.println(count());
	}

	public static int count() {
		int cnt = 0;

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++)
				if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
					cnt++;

		return cnt;
	}

	public static void draw(int x, int y, List<Integer> dir) {
		map[x][y] = true;

		for (int d : dir) {
			switch (d) {
			case RIGHT:
				map[++x][y] = true;
				break;
			case UP:
				map[x][--y] = true;
				break;
			case LEFT:
				map[--x][y] = true;
				break;
			case DOWN:
				map[x][++y] = true;
				break;
			}
		}
	}

	public static List<Integer> getDir(int d, int g) {
		List<Integer> dir = new ArrayList<>();

		dir.add(d);

		while (g-- > 0) {
			for (int i = dir.size() - 1; i >= 0; i--) {
				int predir = (dir.get(i) + 1) % 4;
				dir.add(predir);
			}
		}

		return dir;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (map[i][j] == '.')
					if (check(i, j))
						return;

	}

	public static boolean check(int x, int y) {
		Point up = new Point(x + dx[0], y + dy[0]);
		Point right = new Point(x + dx[1], y + dy[1]);
		Point down = new Point(x + dx[2], y + dy[2]);
		Point left = new Point(x + dx[3], y + dy[3]);

		boolean[] dir = new boolean[4];
		if (!OOB(up.x, up.y) && canGoDown(map[up.x][up.y]))
			dir[0] = true;
		if (!OOB(right.x, right.y) && canGoLeft(map[right.x][right.y]))
			dir[1] = true;
		if (!OOB(down.x, down.y) && canGoUp(map[down.x][down.y]))
			dir[2] = true;
		if (!OOB(left.x, left.y) && canGoRight(map[left.x][left.y]))
			dir[3] = true;

		if (dir[0] && dir[1] && dir[2] && dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " +");
		else if (dir[0] && !dir[1] && dir[2] && !dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " |");
		else if (!dir[0] && dir[1] && !dir[2] && dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " -");
		else if (!dir[0] && dir[1] && dir[2] && !dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " 1");
		else if (dir[0] && dir[1] && !dir[2] && !dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " 2");
		else if (dir[0] && !dir[1] && !dir[2] && dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " 3");
		else if (!dir[0] && !dir[1] && dir[2] && dir[3])
			System.out.println((x + 1) + " " + (y + 1) + " 4");
		else
			return false;

		return true;
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C)
			return true;
		return false;
	}

	public static boolean canGoUp(char c) {
		if (c == '|' || c == '+' || c == '2' || c == '3')
			return true;
		return false;
	}

	public static boolean canGoRight(char c) {
		if (c == '-' || c == '+' || c == '1' || c == '2')
			return true;
		return false;
	}

	public static boolean canGoDown(char c) {
		if (c == '|' || c == '+' || c == '1' || c == '4')
			return true;
		return false;
	}

	public static boolean canGoLeft(char c) {
		if (c == '-' || c == '+' || c == '3' || c == '4')
			return true;
		return false;
	}
}

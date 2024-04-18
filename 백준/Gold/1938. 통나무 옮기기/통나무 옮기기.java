import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int N;
	public static char[][] map;
	public static Point[] start;
	public static Point[] end;
	public static int endIsVertical = 0;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		start = new Point[3];
		end = new Point[3];

		int startIdx = 0;
		int endIdx = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B')
					start[startIdx++] = new Point(i, j);
				else if (map[i][j] == 'E')
					end[endIdx++] = new Point(i, j);
			}
		}

		if (end[0].x + 1 == end[1].x)
			endIsVertical = 1;

		bfs();

		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Tree> q = new LinkedList<>();
		// 중심 좌표를 기준으로 방문 처리, 3번째 요소는 가로, 세로를 표시하기 위함
		boolean[][][] visit = new boolean[N][N][2];

		// 통나무가 가로로 존재하는지, 세로로 존재하는지 표시하기 위한 변수
		// 0이라면 가로, 1이라면 세로
		int isVertical = (start[0].x + 1 == start[1].x) ? 1 : 0;

		q.add(new Tree(start[1].x, start[1].y, isVertical, 0));
		visit[start[1].x][start[1].y][isVertical] = true;

		while (!q.isEmpty()) {
			Tree now = q.poll();

			if (now.x == end[1].x && now.y == end[1].y && now.isVertical == endIsVertical) {
				ans = now.cnt;
				break;
			}

			if (canUp(now.x, now.y, now.isVertical)) {
				int nx = now.x - 1;
				int ny = now.y;
				int nv = now.isVertical;
				if (!visit[nx][ny][nv]) {
					q.add(new Tree(nx, ny, nv, now.cnt + 1));
					visit[nx][ny][nv] = true;
				}
			}

			if (canDown(now.x, now.y, now.isVertical)) {
				int nx = now.x + 1;
				int ny = now.y;
				int nv = now.isVertical;
				if (!visit[nx][ny][nv]) {
					q.add(new Tree(nx, ny, nv, now.cnt + 1));
					visit[nx][ny][nv] = true;
				}
			}

			if (canLeft(now.x, now.y, now.isVertical)) {
				int nx = now.x;
				int ny = now.y - 1;
				int nv = now.isVertical;
				if (!visit[nx][ny][nv]) {
					q.add(new Tree(nx, ny, nv, now.cnt + 1));
					visit[nx][ny][nv] = true;
				}
			}

			if (canRight(now.x, now.y, now.isVertical)) {
				int nx = now.x;
				int ny = now.y + 1;
				int nv = now.isVertical;
				if (!visit[nx][ny][nv]) {
					q.add(new Tree(nx, ny, nv, now.cnt + 1));
					visit[nx][ny][nv] = true;
				}
			}

			if (canRotate(now.x, now.y, now.isVertical)) {
				int nx = now.x;
				int ny = now.y;
				int nv = now.isVertical == 0 ? 1 : 0;
				if (!visit[nx][ny][nv]) {
					q.add(new Tree(nx, ny, nv, now.cnt + 1));
					visit[nx][ny][nv] = true;
				}
			}
		}
	}

	public static boolean canUp(int x, int y, int isVertical) {
		// 통나무가 가로로 있는 경우
		if (isVertical == 0) {
			if (OOB(x - 1, y) || OOB(x - 1, y - 1) || OOB(x - 1, y + 1))
				return false;
			for (int j = y - 1; j <= y + 1; j++)
				if (map[x - 1][j] == '1')
					return false;
		}
		// 통나무가 세로로 있는 경우
		else if (isVertical == 1) {
			if (OOB(x - 2, y))
				return false;
			if (map[x - 2][y] == '1')
				return false;
		}
		return true;
	}

	public static boolean canDown(int x, int y, int isVertical) {
		if (isVertical == 0) {
			if (OOB(x + 1, y) || OOB(x + 1, y - 1) || OOB(x + 1, y + 1))
				return false;
			for (int j = y - 1; j <= y + 1; j++)
				if (map[x + 1][j] == '1')
					return false;
		} else if (isVertical == 1) {
			if (OOB(x + 2, y))
				return false;
			if (map[x + 2][y] == '1')
				return false;
		}
		return true;
	}

	public static boolean canLeft(int x, int y, int isVertical) {
		if (isVertical == 0) {
			if (OOB(x, y - 2))
				return false;
			if (map[x][y - 2] == '1')
				return false;
		} else if (isVertical == 1) {
			if (OOB(x, y - 1) || OOB(x - 1, y - 1) || OOB(x + 1, y - 1))
				return false;
			for (int i = x - 1; i <= x + 1; i++)
				if (map[i][y - 1] == '1')
					return false;
		}
		return true;
	}

	public static boolean canRight(int x, int y, int isVertical) {
		if (isVertical == 0) {
			if (OOB(x, y + 2))
				return false;
			if (map[x][y + 2] == '1')
				return false;
		} else if (isVertical == 1) {
			if (OOB(x, y + 1) || OOB(x - 1, y + 1) || OOB(x + 1, y + 1))
				return false;
			for (int i = x - 1; i <= x + 1; i++)
				if (map[i][y + 1] == '1')
					return false;
		}
		return true;
	}

	public static boolean canRotate(int x, int y, int isVertical) {
		// 통나무가 가로로 있는 경우
		if (isVertical == 0) {
			// 영역을 벗어난 경우
			if (OOB(x - 1, y) || OOB(x + 1, y))
				return false;
			if (OOB(x, y - 1) || OOB(x, y + 1))
				return false;
			// 영역 내에 나무가 존재하는 경우
			for (int i = x - 1; i <= x + 1; i++) {
				if (i == x)
					continue;
				for (int j = y - 1; j <= y + 1; j++) {
					if (map[i][j] == '1')
						return false;
				}
			}
		}
		// 통나무가 세로로 있는 경우
		else if (isVertical == 1) {
			if (OOB(x, y - 1) || OOB(x, y + 1))
				return false;
			if (OOB(x - 1, y) || OOB(x + 1, y))
				return false;
			for (int j = y - 1; j <= y + 1; j++) {
				if (j == y)
					continue;
				for (int i = x - 1; i <= x + 1; i++) {
					if (map[i][j] == '1')
						return false;
				}
			}
		}

		return true;
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return true;
		return false;
	}
}

class Tree {
	int x;
	int y;
	int isVertical;
	int cnt;

	public Tree(int x, int y, int isVertical, int cnt) {
		this.x = x;
		this.y = y;
		this.isVertical = isVertical;
		this.cnt = cnt;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
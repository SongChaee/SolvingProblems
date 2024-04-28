import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] map;
	public static ArrayList<CCTV> list;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static ArrayList<ArrayList<ArrayList<Spot>>> spots;
	public static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<>();

		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new CCTV(idx, i, j, map[i][j]));
					idx++;
				}
			}
		}

		// 카메라 별로 특정 방향을 보고 있을 때, 볼 수 있는 칸을 담는 리스트
		spots = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
			spots.add(new ArrayList<>());
		for (CCTV c : list) {
			for (int dir = 0; dir < 4; dir++)
				spots.get(c.idx).add(new ArrayList<>());
		}

		for (CCTV c : list) {
			for (int dir = 0; dir < 4; dir++) {
				int x = c.x;
				int y = c.y;
				while (true) {
					if (OOB(x + dx[dir], y + dy[dir]))
						break;
					if (map[x + dx[dir]][y + dy[dir]] == 6)
						break;
					x += dx[dir];
					y += dy[dir];
					if (map[x][y] > 0 && map[x][y] < 6)
						continue;
					spots.get(c.idx).get(dir).add(new Spot(x, y));
				}
			}
		}

		int[] dir = new int[list.size()];
		setDir(0, dir);

		System.out.println(ans);

	}

	public static void setDir(int idx, int[] d) {
		if (idx >= list.size()) {
			// 현재 설정된 방향에 따라 감시하는 칸 마킹 후 사각지대 영역 카운트
			int[][] now = new int[N][M];
			for (int i = 0; i < N; i++)
				now[i] = Arrays.copyOf(map[i], M);

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).type == 1) {
					for (Spot s : spots.get(i).get(d[i])) {
						now[s.x][s.y] = 7;
					}
				} else if (list.get(i).type == 2) {
					for (Spot s : spots.get(i).get(d[i])) {
						now[s.x][s.y] = 7;
					}
					for (Spot s : spots.get(i).get((d[i] + 2) % 4)) {
						now[s.x][s.y] = 7;
					}
				} else if (list.get(i).type == 3) {
					for (Spot s : spots.get(i).get(d[i])) {
						now[s.x][s.y] = 7;
					}
					for (Spot s : spots.get(i).get((d[i] + 1) % 4)) {
						now[s.x][s.y] = 7;
					}
				} else if (list.get(i).type == 4) {
					for (Spot s : spots.get(i).get(d[i])) {
						now[s.x][s.y] = 7;
					}
					for (Spot s : spots.get(i).get((d[i] + 1) % 4)) {
						now[s.x][s.y] = 7;
					}
					for (Spot s : spots.get(i).get((d[i] + 2) % 4)) {
						now[s.x][s.y] = 7;
					}
				} else if (list.get(i).type == 5) {
					for (int a = 0; a < 4; a++)
						for (Spot s : spots.get(i).get(a))
							now[s.x][s.y] = 7;
				}
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++)
					if (now[i][j] == 0)
						cnt++;
			}

			ans = Math.min(ans, cnt);

			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			d[idx] = dir;
			setDir(idx + 1, d);
		}
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return true;
		return false;
	}
}

class Spot {
	int x;
	int y;

	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class CCTV {
	int idx;
	int x;
	int y;
	int type;

	public CCTV(int idx, int x, int y, int type) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static boolean[][] map;
	public static Queue<Spot> cheese = new LinkedList<>();
	public static boolean[][] isHole;
	public static int time, pieces;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					map[i][j] = true;
					cheese.add(new Spot(i, j));
				}
			}
		}

		time = 0;
		while (cheese.size() > 0) {
			pieces = cheese.size();

			// 치즈의 구멍 판단
			findHole();

			// 치즈 테두리 녹기
			melt();

			time++;
		}

		System.out.println(time);
		System.out.println(pieces);
	}

	public static void melt() {
		int cheeseCnt = cheese.size();
		Queue<Spot> select = new LinkedList<>();

		for (int i = 0; i < cheeseCnt; i++) {
			Spot now = cheese.poll();

			// now를 기준으로 동서남북 네 방향에 위치한 칸 판별
			// 1. 판의 영역 밖인지
			// 2. 치즈가 없는, 공기가 있는 칸인지
			// 3. 치즈가 없는, 공기가 없는 칸인지
			// 4. 치즈가 있는 칸인지
			int oob = 0;
			int empty = 0;
			int hole = 0;
			int exist = 0;

			for (int dir = 0; dir < 4; dir++) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];

				if (OOB(nx, ny))
					oob++;

				if (!map[nx][ny]) {
					if (isHole[nx][ny])
						hole++;
					else
						empty++;
				}

				if (map[nx][ny])
					exist++;
			}

			// 치즈의 테두리 부분이 아니라면 다시 cheese 큐에 담기
			// 치즈의 테두리 부분이라면 녹아서 없어짐 처리 하고
			if (exist == 4 || exist + hole == 4) {
				cheese.add(new Spot(now.x, now.y));
			} else {
				select.add(new Spot(now.x, now.y));
			}
		}

		while (!select.isEmpty()) {
			Spot s = select.poll();
			map[s.x][s.y] = false;
		}
	}

	public static void findHole() {
		isHole = new boolean[N][M];
		Queue<Spot> q;
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j] && !visit[i][j]) {
					q = new LinkedList<>();
					Queue<Spot> tmp = new LinkedList<>();
					boolean flag = false;

					q.add(new Spot(i, j));
					tmp.add(new Spot(i, j));
					visit[i][j] = true;

					while (!q.isEmpty()) {
						Spot now = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = now.x + dx[dir];
							int ny = now.y + dy[dir];

							if (OOB(nx, ny)) {
								flag = true;
								continue;
							}

							if (!map[nx][ny] && !visit[nx][ny]) {
								q.add(new Spot(nx, ny));
								tmp.add(new Spot(nx, ny));
								visit[nx][ny] = true;
							}
						}
					}

					if (!flag) {
						while (!tmp.isEmpty()) {
							Spot hole = tmp.poll();
							isHole[hole.x][hole.y] = true;
						}
					}
				}
			}
		}
	}

	public static boolean OOB(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
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

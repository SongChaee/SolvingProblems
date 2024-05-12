import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int G, R;
	public static int[][] map;
	public static ArrayList<Ground> spray;
	public static int sprayN;
	public static boolean[] visit;
	public static int[] greens, reds;
	public static int ans = 0;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static final int RED = 3;
	public static final int GREEN = 4;
	public static final int FLOWER = 5;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		spray = new ArrayList<>();
		greens = new int[G];
		reds = new int[R];
		visit = new boolean[10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					spray.add(new Ground(i, j));
				}
			}
		}

		sprayN = spray.size();
		selectG(0, 0);

		System.out.println(ans);
	}

	// 초록 배양액을 뿌릴 구역 선택
	// sprayN개의 구역 중 G개 선택하는 경우
	public static void selectG(int start, int cnt) {
		if (cnt == G) {
			selectR(0, 0);
			return;
		}

		for (int i = start; i < sprayN; i++) {
			if (!visit[i]) {
				visit[i] = true;
				greens[cnt] = i;
				selectG(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}

	// 빨간 배양액을 뿌릴 구역 선택
	// 초록 배양액이 뿌려진 구역을 제외하고 R개 선택하는 경우
	public static void selectR(int start, int cnt) {
		if (cnt == R) {
			bfs();
			return;
		}

		for (int i = start; i < sprayN; i++) {
			if (!visit[i]) {
				visit[i] = true;
				reds[cnt] = i;
				selectR(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}

	// 배양액이 퍼져 꽃이 피는지 확인
	public static void bfs() {
		Queue<Ground> q = new LinkedList<>();
		Pair[][] state = new Pair[N][M];

		for (int i = 0; i < N; i++)
			Arrays.fill(state[i], new Pair());

		// 배양액 배치
		for (int i = 0; i < G; i++) {
			Ground g = spray.get(greens[i]);
			state[g.x][g.y] = new Pair(0, GREEN);
			q.add(new Ground(g.x, g.y));
		}
		for (int i = 0; i < R; i++) {
			Ground r = spray.get(reds[i]);
			state[r.x][r.y] = new Pair(0, RED);
			q.add(new Ground(r.x, r.y));
		}

		int flower = 0;

		while (!q.isEmpty()) {
			Ground now = q.poll();
			int x = now.x;
			int y = now.y;
			int time = state[x][y].time;
			int type = state[x][y].type;

			if (type == FLOWER)
				continue;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (OOB(nx, ny))
					continue;

				if (map[nx][ny] != 0) {
					// 배양액이 퍼지지 않은 땅인 경우
					if (state[nx][ny].type == 0) {
						state[nx][ny] = new Pair(time + 1, type);
						q.add(new Ground(nx, ny));
					}

					// 빨간 배양액이 퍼진 구역에 초록 배양액이 퍼진 경우
					else if (state[nx][ny].type == RED) {
						if (type == GREEN && state[nx][ny].time == time + 1) {
							flower++;
							state[nx][ny].type = FLOWER;
						}
					}

					// 초록 배양액이 퍼진 구역에 빨간 배양액이 퍼진 경우
					else if (state[nx][ny].type == GREEN) {
						if (type == RED && state[nx][ny].time == time + 1) {
							flower++;
							state[nx][ny].type = FLOWER;
						}
					}
				}
			}

		}

		ans = Math.max(ans, flower);
	}

	public static boolean OOB(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}
}

class Ground {
	int x;
	int y;
	int time;

	public Ground(int x, int y) {
		this.x = x;
		this.y = y;
		this.time = 0;
	}
}

class Pair {
	int time;
	int type;

	public Pair() {
	}

	public Pair(int time, int type) {
		this.time = time;
		this.type = type;
	}
}

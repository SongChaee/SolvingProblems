import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] country;
	static int days;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] union;
	static int idx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		days = 0;
		while (true) {
			if (!open())
				break;
			
			move();
			
			days++;
		}
		
		System.out.print(days);

	}

	// 연합 국가 간 인구 이동
	public static void move() {
		ArrayList<Queue<int[]>> list = new ArrayList<>();
		for(int i = 0; i < idx; i++)
			list.add(new LinkedList<>());
		int[] sum = new int[idx];
		int[] cnt = new int[idx];
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				// 연합에 성공한 국가인 경우
				if(union[x][y] != 0) {
					int n = union[x][y];
					list.get(n).add(new int[] {x, y});
					sum[n] += country[x][y];
					cnt[n]++;
				}
			}
		}
		
		for(int i = 1; i < idx; i++) {
			int avg = sum[i] / cnt[i];
			while(!list.get(i).isEmpty()) {
				int[] check = list.get(i).poll();
				country[check[0]][check[1]] = avg;
			}
		}
	}

	// 개방을 시도하여 연합 국가 생성
	public static boolean open() {
		union = new int[N][N];
		idx = 1;
		boolean flag = false;

		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (visit[x][y])
					continue;
				flag = false;

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (!inRange(nx, ny))
						continue;
					if (visit[nx][ny])
						continue;

					if (canMerge(x, y, nx, ny)) {
						union[x][y] = idx;
						union[nx][ny] = idx;
						visit[x][y] = true;
						visit[nx][ny] = true;

						q.add(new int[] { nx, ny });
						flag = true;

						while (!q.isEmpty()) {
							int[] now = q.poll();

							for (int d = 0; d < 4; d++) {
								int nnx = now[0] + dx[d];
								int nny = now[1] + dy[d];

								if (!inRange(nnx, nny))
									continue;
								if (visit[nnx][nny])
									continue;

								if (canMerge(now[0], now[1], nnx, nny)) {
									union[nnx][nny] = idx;
									visit[nnx][nny] = true;
									q.add(new int[] { nnx, nny });
								}
							}
						}
					}
				}
				if (flag)
					idx++;
			}
		}

		return (idx >= 2 ? true : false);
	}

	public static boolean canMerge(int x, int y, int nx, int ny) {
		int gap = Math.abs(country[x][y] - country[nx][ny]);

		if (gap >= L && gap <= R)
			return true;

		return false;
	}

	public static boolean inRange(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		return true;
	}
}

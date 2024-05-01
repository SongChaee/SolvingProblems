import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K;
	public static Sticker[] stickers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		stickers = new Sticker[K];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			stickers[i] = new Sticker(n, m);

			for (int a = 0; a < n; a++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int b = 0; b < m; b++) {
					stickers[i].shape[a][b] = Integer.parseInt(st.nextToken());
					if (stickers[i].shape[a][b] == 1)
						stickers[i].size++;
				}
			}
		}

		boolean[][] map = new boolean[N][M];
		for (Sticker s : stickers) {
			int[] result = canAttach(map, s);
			if (result[0] != -1 && result[1] != -1) {
				for (int x = 0; x < s.n; x++) {
					for (int y = 0; y < s.m; y++) {
						if (s.shape[x][y] == 1)
							map[x + result[0]][y + result[1]] = true;
					}
				}
			} else {
				Sticker rotated = new Sticker(s.n, s.m);
				rotated.size = s.size;
				for (int i = 0; i < s.n; i++)
					rotated.shape[i] = Arrays.copyOf(s.shape[i], s.m);

				for (int i = 0; i < 3; i++) {
					rotated = rotate(rotated);
					result = canAttach(map, rotated);

					if (result[0] != -1 && result[1] != -1) {
						for (int x = 0; x < rotated.n; x++) {
							for (int y = 0; y < rotated.m; y++) {
								if (rotated.shape[x][y] == 1)
									map[x + result[0]][y + result[1]] = true;
							}
						}
						break;
					}
				}
			}
		}

		System.out.println(count(map));

	}

	public static int count(boolean[][] map) {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (map[i][j])
					cnt++;
		}

		return cnt;
	}

	public static Sticker rotate(Sticker s) {
		int[][] rotatedShape = new int[s.m][s.n];
		int rotatedN = s.m;
		int rotatedM = s.n;

		for (int i = 0; i < s.n; i++) {
			for (int j = 0; j < s.m; j++) {
				rotatedShape[j][s.n - 1 - i] = s.shape[i][j];
			}
		}

		Sticker after = new Sticker(rotatedN, rotatedM);
		after.size = s.size;
		after.shape = rotatedShape;

		return after;
	}

	public static int[] canAttach(boolean[][] map, Sticker s) {
		int[] arr = new int[2];
		Arrays.fill(arr, -1);
		boolean flag = false;

		for (int i = 0; i <= N - s.n; i++) {
			for (int j = 0; j <= M - s.m; j++) {
				if (!flag) {
					int cnt = 0;
					for (int x = 0; x < s.n; x++) {
						for (int y = 0; y < s.m; y++) {
							if (s.shape[x][y] == 1 && !map[i + x][j + y])
								cnt++;
						}
					}
					if (cnt == s.size) {
						flag = true;
						arr[0] = i;
						arr[1] = j;
					}
				}
			}
		}

		return arr;
	}

}

class Sticker {
	int n;
	int m;
	int[][] shape;
	int size = 0;

	public Sticker(int n, int m) {
		this.n = n;
		this.m = m;
		this.shape = new int[n][m];
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		move(board, 0);

		System.out.print(ans);

	}

	public static void move(int[][] board, int cnt) {
		if (cnt >= 5) {
			int max = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					max = Math.max(max, board[i][j]);
			ans = Math.max(ans, max);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int[][] next = push(copy(board), dir);
			move(next, cnt + 1);
		}
	}

	public static int[][] push(int[][] board, int dir) {
		boolean[][] merged = new boolean[N][N];

		switch (dir) {
		case (0):
			for (int j = 0; j < N; j++) {
				for (int i = 1; i < N; i++) {
					if (board[i][j] == 0)
						continue;
					int x = i;
					while (x - 1 >= 0 && board[x - 1][j] == 0) {
						board[x - 1][j] = board[x][j];
						board[x][j] = 0;
						x--;
					}
					if (x - 1 >= 0 && board[x - 1][j] == board[x][j] && !merged[x - 1][j]) {
						board[x - 1][j] *= 2;
						board[x][j] = 0;
						merged[x - 1][j] = true;
					}
				}
			}
			break;
		case (1):
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) {
					if (board[i][j] == 0)
						continue;
					int y = j;
					while (y + 1 < N && board[i][y + 1] == 0) {
						board[i][y + 1] = board[i][y];
						board[i][y] = 0;
						y++;
					}
					if (y + 1 < N && board[i][y + 1] == board[i][y] && !merged[i][y + 1]) {
						board[i][y + 1] *= 2;
						board[i][y] = 0;
						merged[i][y + 1] = true;
					}
				}
			}
			break;
		case (2):
			for (int j = 0; j < N; j++) {
				for (int i = N - 2; i >= 0; i--) {
					if (board[i][j] == 0)
						continue;
					int x = i;
					while (x + 1 < N && board[x + 1][j] == 0) {
						board[x + 1][j] = board[x][j];
						board[x][j] = 0;
						x++;
					}
					if (x + 1 < N && board[x + 1][j] == board[x][j] && !merged[x + 1][j]) {
						board[x + 1][j] *= 2;
						board[x][j] = 0;
						merged[x + 1][j] = true;
					}
				}
			}
			break;
		case (3):
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (board[i][j] == 0)
						continue;
					int y = j;
					while (y - 1 >= 0 && board[i][y - 1] == 0) {
						board[i][y - 1] = board[i][y];
						board[i][y] = 0;
						y--;
					}
					if (y - 1 >= 0 && board[i][y - 1] == board[i][y] && !merged[i][y - 1]) {
						board[i][y - 1] *= 2;
						board[i][y] = 0;
						merged[i][y - 1] = true;
					}
				}
			}
			break;
		}

		return board;
	}
	
	public static int[][] copy(int[][] origin) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) 
            copy[i] = origin[i].clone();
        
        return copy;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] board;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][][][] visited;
	static final int LIMIT = 10;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		int rx = 0, ry = 0, bx = 0, by = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (board[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		visited = new boolean[N][M][N][M];
		System.out.println(bfs(rx, ry, bx, by));
	}

	static int bfs(int rx, int ry, int bx, int by) {
		Queue<State> queue = new ArrayDeque<>();
		queue.offer(new State(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			State current = queue.poll();

			if (current.depth >= LIMIT)
				continue;

			for (int i = 0; i < 4; i++) {
				int nrx = current.rx, nry = current.ry;
				int nbx = current.bx, nby = current.by;
				boolean redInHole = false, blueInHole = false;

				// 빨간 구슬 이동
				while (board[nrx + dx[i]][nry + dy[i]] != '#') {
					nrx += dx[i];
					nry += dy[i];
					if (board[nrx][nry] == 'O') {
						redInHole = true;
						break;
					}
				}

				// 파란 구슬 이동
				while (board[nbx + dx[i]][nby + dy[i]] != '#') {
					nbx += dx[i];
					nby += dy[i];
					if (board[nbx][nby] == 'O') {
						blueInHole = true;
						break;
					}
				}

				// 파란 구슬이 구멍에 빠지면 실패
				if (blueInHole)
					continue;

				// 빨간 구슬만 구멍에 빠지면 성공
				if (redInHole)
					return current.depth + 1;

				// 빨간 구슬과 파란 구슬이 같은 위치에 있으면 위치 조정
				if (nrx == nbx && nry == nby) {
					switch (i) {
					case 0: // 북쪽
						if (current.rx > current.bx)
							nrx++;
						else
							nbx++;
						break;
					case 1: // 동쪽
						if (current.ry > current.by)
							nby--;
						else
							nry--;
						break;
					case 2: // 남쪽
						if (current.rx > current.bx)
							nbx--;
						else
							nrx--;
						break;
					case 3: // 서쪽
						if (current.ry > current.by)
							nry++;
						else
							nby++;
						break;
					}
				}

				// 방문 여부 체크 후 큐에 삽입
				if (!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					queue.offer(new State(nrx, nry, nbx, nby, current.depth + 1));
				}
			}
		}

		// 10번 이내에 구슬을 빼낼 수 없으면 -1 반환
		return -1;
	}

	static class State {
		int rx, ry, bx, by, depth;

		State(int rx, int ry, int bx, int by, int depth) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.depth = depth;
		}
	}
}

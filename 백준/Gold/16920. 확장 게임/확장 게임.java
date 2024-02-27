import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, P;
	static char[][] map;
	static int[] spread;
	static int[] area;
	static ArrayList<Queue<int[]>> q;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		spread = new int[P + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= P; i++)
			spread[i] = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		area = new int[P + 1];
		q = new ArrayList<>();
		for (int i = 0; i <= P; i++)
			q.add(new LinkedList<>());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] != '.' && map[i][j] != '#') {
					area[map[i][j] - '0']++;
					q.get(map[i][j] - '0').add(new int[] { i, j });
				}
			}
		}

		int playerIdx = 1;
		int expand = 0;

		while (true) {
			int cnt = turn(playerIdx);
			
			area[playerIdx] += cnt;
			expand += cnt;
			
			playerIdx++;
			if(playerIdx > P) {
				if(expand == 0)
					break;
				playerIdx = 1;
				expand = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= P; i++)
			sb.append(area[i]).append(" ");
		System.out.print(sb.toString());

	}

	public static int turn(int player) {
		int cnt = 0;
		int dist = 1;

		while (!q.get(player).isEmpty()) {
			int size = q.get(player).size();

			for (int i = 0; i < size; i++) {
				int[] now = q.get(player).poll();

				for (int dir = 0; dir < 4; dir++) {
					int nx = now[0] + dx[dir];
					int ny = now[1] + dy[dir];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (map[nx][ny] == '.') {
						q.get(player).add(new int[] { nx, ny });
						map[nx][ny] = (char) (player + '0');
						cnt++;
					}
				}
			}

			dist++;
			if (dist > spread[player])
				break;
		}

		return cnt;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] map;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = tmp.charAt(j);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];

		q.add(new int[] { x, y, 0 });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			ans = Math.max(ans, now[2]);
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
				
				if(OOB(nx, ny))
					continue;
				
				if(visit[nx][ny])
					continue;
				
				if(map[nx][ny] == 'W')
					continue;
				
				q.add(new int[] {nx, ny, now[2] + 1});
				visit[nx][ny] = true;
			}
		}
	}

	public static boolean OOB(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return true;
		return false;
	}
}

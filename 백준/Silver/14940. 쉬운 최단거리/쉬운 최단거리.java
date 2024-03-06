import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					q.add(new int[] {i, j, 0});
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				
				if(visit[nx][ny])
					continue;
				
				if(map[nx][ny] == 0)
					continue;
				
				q.add(new int[] {nx, ny, now[2] + 1});
				visit[nx][ny] = true;
				map[nx][ny] = now[2] + 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visit[i][j])
					sb.append("-1").append(" ");
				else
					sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}

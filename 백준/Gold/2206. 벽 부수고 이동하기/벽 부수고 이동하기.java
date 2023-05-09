import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		if(N == 1 && M == 1) {
			System.out.print("1");
			return;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1, 0});
		int[][][] dist = new int[N][M][2];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
		
		while(!q.isEmpty()) {
			int[] check = q.poll();
			if(check[0] == N-1 && check[1] == M-1) break;
			
			for(int dir = 0; dir < 4; dir++) {
				int x = check[0] + dx[dir];
				int y = check[1] + dy[dir];
				if(x < 0 || x >= N || y < 0 || y >= M) continue;
				if(map[x][y] == '0' && dist[x][y][check[3]] == Integer.MAX_VALUE) {
					q.add(new int[] {x, y, check[2] + 1, check[3]});
					dist[x][y][check[3]] = check[2] + 1;
				}
				if(check[3] == 0 && map[x][y] == '1' && dist[x][y][1] == Integer.MAX_VALUE) {
					q.add(new int[] {x, y, check[2] + 1, 1});
					dist[x][y][1] = check[2] + 1;
				}
			}
		}
		
		if(dist[N-1][M-1][0] == Integer.MAX_VALUE && dist[N-1][M-1][1] == Integer.MAX_VALUE)
			System.out.print("-1");
		else
			System.out.print(Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]));
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<int[]> wall = new LinkedList<>();
	public static int[][] map;
	public static int N, M;
	public static int safenum = 0;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		boolean[] used = new boolean[N*M];
		int usedidx = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 || map[i][j] == 2)
					used[usedidx] = true;
				usedidx++;
			}
		}
		
		int[] pick = new int[3];
		pick3(used, pick, 0, 0);
		
		int[][] copy;
		for(int i = 0; i < wall.size(); i++) {
			int[] check = wall.get(i);
			int x1 = check[0] / M;
			int y1 = check[0] % M;
			int x2 = check[1] / M;
			int y2 = check[1] % M;
			int x3 = check[2] / M;
			int y3 = check[2] % M;
            
			copy = new int[N][M];
			for(int k = 0; k < N; k++)
				copy[k] = Arrays.copyOf(map[k], M);
			copy[x1][y1] = 1;
			copy[x2][y2] = 1;
			copy[x3][y3] = 1;
			
			spreadvirus(copy);
		}
		
		System.out.print(safenum);
	}
	
	// 3개의 벽을 둔 후 바이러스 확산, 안전 영역 크기 구하기
	public static void spreadvirus(int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					q.add(new int[] {i, j});
					visit[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] check = q.poll();
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = check[0] + dx[dir];
							int ny = check[1] + dy[dir];
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if(!visit[nx][ny] && map[nx][ny] == 0) {
								q.add(new int[] {nx, ny});
								visit[nx][ny] = true;
								map[nx][ny] = 2;
							}
						}
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] == 0 && !visit[i][j])
					count++;
        
		safenum = Math.max(safenum, count);
	}
	
	// 벽을 놓을 수 있는 칸 3개 고르는 조합 생성
	public static void pick3(boolean[] used, int[] pick, int index, int k) {
		if(k == 3) {
			int[] combi = Arrays.copyOf(pick, 3);
			wall.add(combi);
			return;
		}
		if(index >= used.length) return;
		
		if(!used[index]) {
			pick[k] = index;
			pick3(used, pick, index + 1, k + 1);
		}
		pick3(used, pick, index + 1, k);
	}
}
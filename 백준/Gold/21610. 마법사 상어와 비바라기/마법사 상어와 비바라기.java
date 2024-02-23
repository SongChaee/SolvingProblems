import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N, M;
	static int[][] water;
	static Queue<int[]> cloud;
	static boolean[][] rained;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		water = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				water[i][j] = Integer.parseInt(st.nextToken());
		}

		cloud = new LinkedList<>();
		rained = new boolean[N][N];
		cloud.add(new int[] { N - 1, 0 });
		cloud.add(new int[] { N - 1, 1 });
		cloud.add(new int[] { N - 2, 0 });
		cloud.add(new int[] { N - 2, 1 });

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			move(dir - 1, dis);
			makeCloud();
		}
		
		System.out.print(sum());
	}
	
	// 비구름이 di 방향으로 si만큼 이동하는 메서드
	public static void move(int dir, int dis) {
		int size = cloud.size();
		
		for(int i = 0; i < size; i++) {
			int[] now = cloud.poll();
			
			int nx = now[0] + dx[dir] * dis;
			int ny = now[1] + dy[dir] * dis;
			
			if(nx < 0)
				while(nx < 0)
					nx += N;
			else if(nx >= N)
				while(nx >= N)
					nx -= N;
			
			if(ny < 0)
				while(ny < 0)
					ny += N;
			else if(ny >= N)
				while(ny >= N)
					ny -= N;
			
			// 이동 후 비가 내림
			cloud.add(new int[] {nx, ny});
			rain(nx, ny);
		}
		
		for(int i = 0; i < size; i++) {
			int[] now = cloud.poll();
			magic(now[0], now[1]);
		}
	}
	
	// 비구름이 있는 칸의 물이 1 증가하는 메서드
	// 구름이 사라진 칸 표시
	public static void rain(int x, int y) {
		water[x][y] += 1;
		rained[x][y] = true;
	}
	
	// 물복사버그 마법 메서드
	// 대각선에 물이 있는 바구니 수만큼 물 양 증가
	public static void magic(int x, int y) {
		for(int dir = 1; dir < 8; dir++) {
			if(dir % 2 == 0) continue;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(water[nx][ny] > 0)
				water[x][y] += 1;
		}
	}
	
	// 물의 양이 2이상인 칸에 구름 생성 메서드
	public static void makeCloud() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(water[i][j] >= 2 && !rained[i][j]) {
					water[i][j] -= 2;
					cloud.add(new int[] {i, j});
				}
			}
		}
		
		// 이전에 비가 내렸던 칸들 초기화
		rained = new boolean[N][N];
	}
	
	// 물 양의 총 합을 구하는 메서드
	public static int sum() {
		int result = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				result += water[i][j];
		
		return result;
	}
}
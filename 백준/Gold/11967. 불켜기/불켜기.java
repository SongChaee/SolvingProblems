import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	// 방의 불 켜짐 여부
	static boolean[][] isOn;
	// 방문 여부
	static boolean[][] visit;
	static ArrayList<ArrayList<int[]>> sw;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		isOn = new boolean[N][N];
		sw = new ArrayList<>();
		for (int i = 0; i < N * N; i++)
			sw.add(new ArrayList<>());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			sw.get(x * N + y).add(new int[] { a, b });
		}
		
		bfs();
		
		System.out.print(ans);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N][N];
		
		// 시작점
		q.add(new int[] {0, 0});
		isOn[0][0] = true;
		visit[0][0] = true;
		
		// 불을 킨 적이 있는지 여부를 나타내는 플래그
		boolean flag = false;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int[] next : sw.get(now[0] * N + now[1])) {
				if(!isOn[next[0]][next[1]]) {
					isOn[next[0]][next[1]] = true;
					ans++;
					flag = true;
				}
			}
			
			// 칸 이동
			for(int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				
				// 불이 꺼져 있는 방인 경우
				if(!isOn[nx][ny])
					continue;
				
				// 방문했던 방인 경우
				if(visit[nx][ny])
					continue;
				
				q.add(new int[] {nx, ny});
				visit[nx][ny] = true;
			}
		}
		
		// 불을 하나라도 켰다면 다시 bfs 수행
		if(flag)
			bfs();
	}
}
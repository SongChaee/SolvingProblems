import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] map;
	public static boolean[][] exist;
	public static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 지도 정보
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		exist = new boolean[N][N];
		
		// 사과 위치
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = true;
		}
		
		// 방향 정보
		int L = Integer.parseInt(br.readLine());
		Queue<String[]> dirInfo = new LinkedList<>();
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dirInfo.add(new String[] {st.nextToken(), st.nextToken()});
		}
		
		// 진행 전 관련 변수 설정
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		// 뱀 이동 시작
		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] {0, 0});
		exist[0][0] = true;
		int time = 0;
		int dir = 0;
		
		while(true) {
			// 현재 위치 확인 
			int[] check = snake.peekFirst();
			
			// 방향 전환 판단
			if(!dirInfo.isEmpty() && time == Integer.parseInt(dirInfo.peek()[0])) {
				if(dirInfo.peek()[1].equals("L"))
					dir = (dir + 3) % 4;
				else
					dir = (dir + 1) % 4;
				dirInfo.poll();
			}
			
			// 다음 위치 결정
			int nx = check[0] + dx[dir];
			int ny = check[1] + dy[dir];
			if(isOver(nx, ny)) break;
			
			// 사과 유무에 따른 몸 길이 조절
			// 사과가 없다면 꼬리부분 좌표를 꺼내고
			// 있다면 사과를 없애주기
			if(!map[check[0]][check[1]]) {
				int[] pass = snake.pollLast();
				exist[pass[0]][pass[1]] = false;
			}else {
				map[check[0]][check[1]] = false;
			}

			// 다음 칸으로 이동
			snake.addFirst(new int[] {nx, ny});
			exist[nx][ny] = true;

			// 시간 증가
			time++;
		}
		
		System.out.print(time + 1);
	}
	
	// 게임 종료 조건
	public static boolean isOver(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N)
			return true;
		if(exist[x][y])
			return true;
		
		return false;
	}
}
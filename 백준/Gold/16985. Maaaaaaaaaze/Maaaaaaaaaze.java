import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<int[][]> board = new ArrayList<>();
	public static ArrayList<int[]> orderlist = new ArrayList<>();
	public static boolean[] used = new boolean[5];
	public static int[] order = new int[5];
	public static int[] dir = new int[5];
	public static int min = Integer.MAX_VALUE;
	public static boolean possible = false;
	public static int[] dh = {-1, 1, 0, 0, 0, 0};
	public static int[] dr = {0, 0, -1, 1, 0, 0};
	public static int[] dc = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// board의 개수
		for(int n = 0; n <  5; n++) {
			int[][] input = new int[5][5];
			for(int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 5; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 3번 회전 시킨 board도 boardlist에 추가
			// boardlist
			// 0~3 : 0번째판, 4~7 : 1번째판
			// 8~11 : 2번째판, 12~15 : 3번째판, 16~19 : 4번째판
			board.add(input);
			for(int r = 0; r < 3; r++) {
				input = rotate(input);
				board.add(input);
			}
		}


		combination(0);
		direction(0);
		
		if(possible)
			System.out.print(min);
		else
			System.out.print("-1");
		
	}
	
	// 5개의 판 각각 특정 방향 dir으로 order 순서로 쌓는 메서드
	public static void makemaze(int[] dir) {
		int[][][] maze = new int[5][5][5];
		
		for(int i = 0; i < orderlist.size(); i++) {
			int[] ord = orderlist.get(i);
			
			for(int h = 0; h < 5; h++) {
				for(int r = 0; r < 5; r++)
					maze[h][r] = board.get(4*ord[h]+dir[ord[h]])[r];
			}
			
			findmin(maze);
		}
	}
	
	// 3차원 배열에서 최단 거리를 계산하는 메서드
	public static void findmin(int[][][] maze) {
		if(maze[0][0][0] == 0) return;
		if(maze[4][4][4] == 0) return;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visit = new boolean[5][5][5];
		q.add(new int[] {0, 0, 0, 0});
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] check = q.poll();
			if(check[0] == 4 && check[1] == 4 && check[2] == 4) {
				min = Math.min(min, check[3]);
				possible = true;
				return;
			}
			if(check[3] >= min) return;
			
			for(int dir = 0; dir < 6; dir++) {
				int nh = check[0] + dh[dir];
				int nr = check[1] + dr[dir];
				int nc = check[2] + dc[dir];
				
				if(nh < 0 || nh > 4 || nr < 0 || nr > 4 || nc < 0 || nc > 4)
					continue;
				if(maze[nh][nr][nc] == 0) continue;
				if(visit[nh][nr][nc]) continue;
				
				q.add(new int[] {nh, nr, nc, check[3] + 1});
				visit[nh][nr][nc] = true;
			}
		}
	}
	
	// n번째판의 4종류 중에서 어떤 종류를 쓸지 정하는 메서드
	public static void direction(int k) {
		if(k == 5) {
			makemaze(dir);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			dir[k] = i;
			direction(k+1);
		}
	}
	
	// 사용할 판의 종류는 정해졌고, 어떤 순서로 쌓을지를 정하는 메서드
	public static void combination(int k) {
		if(k == 5) {
			int[] result = Arrays.copyOf(order, 5);
			orderlist.add(result);
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			if(!used[i]) {
				order[k] = i;
				used[i] = true;
				combination(k+1);
				used[i] = false;
			}
		}
	}
	
	// 주어진 2차원 배열 시계방향으로 90도 회전시키는 메서드
	public static int[][] rotate(int[][] arr){
		int[][] rot = new int[5][5];
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				rot[i][j] = arr[4-j][i];
		
		return rot;
	}
}
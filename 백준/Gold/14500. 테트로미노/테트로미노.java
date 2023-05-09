import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<boolean[][]> pattern = new LinkedList<>();
	public static int[][] board;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 패턴 생성
		boolean[] arr;
		arr = new boolean[6];
		make3by2(arr, 0, 0);
		arr = new boolean[6];
		make2by3(arr, 0, 0);
		
		// 1x4 체크
		int sum;
		for(int i= 0; i < N; i++) {
			for(int j = 0; j < M - 3; j++) {
				sum = board[i][j];
				for(int k = 1; k < 4; k++)
					sum += board[i][j+k];
				max = Math.max(max, sum);
			}
		}
		
		// 4x1 체크
		for(int j = 0; j < M; j++) {
			for(int i = 0; i < N - 3; i++) {
				sum = board[i][j];
				for(int k = 1; k < 4; k++)
					sum += board[i+k][j];
				max = Math.max(max, sum);
			}
		}
		
		// 3x2 체크
		int[][] map;
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				map = new int[3][2];
				for(int r = 0; r < 3; r++)
					for(int c = 0; c < 2; c++)
						map[r][c] = board[i+r][j+c];
				
				for(int k = 0; k < 10; k++) {
					sum = 0;
					boolean[][] check = pattern.get(k);
					for(int r = 0; r < 3; r++)
						for(int c = 0; c < 2; c++)
							if(check[r][c])
								sum += map[r][c];
					max = Math.max(max, sum);
				}
			}
		}
		
		// 2x3 체크
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				map = new int[2][3];
				for(int r = 0; r < 2; r++)
					for(int c = 0; c < 3; c++)
						map[r][c] = board[i+r][j+c];
				
				for(int k = 10; k < 20; k++) {
					sum = 0;
					boolean[][] check = pattern.get(k);
					for(int r = 0; r < 2; r++)
						for(int c = 0; c < 3; c++)
							if(check[r][c])
								sum += map[r][c];
					max = Math.max(max, sum);
				}
			}
		}
		
		System.out.print(max);
	}
	
	// 3x2 패턴 만들기
	public static void make3by2(boolean[] arr, int index, int k) {
		if(k == 2) {
			if(arr[2])
				if(arr[1] || arr[3] || arr[5]) return;
			if(arr[3])
				if(arr[0] || arr[4]) return;
			
			boolean[][] pat = new boolean[3][2];
			int idx = 0;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					if(!arr[idx])
						pat[i][j] = true;
					idx++;
				}
			}
			pattern.add(pat);
			return;
		}
		if(index >= arr.length) return;
		
		arr[index] = true;
		make3by2(arr, index+1, k+1);
		
		arr[index] = false;
		make3by2(arr, index+1, k);
	}
	
	// 2x3 패턴 만들기
	public static void make2by3(boolean[] arr, int index, int k) {
		if(k == 2) {
			if(arr[1])
				if(arr[3] || arr[4] || arr[5]) return;
			if(arr[4])
				if(arr[0] || arr[2]) return;
			
			boolean[][] pat = new boolean[2][3];
			int idx = 0;
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3; j++) {
					if(!arr[idx])
						pat[i][j] = true;
					idx++;
				}
			}
			pattern.add(pat);
			return;
		}
		if(index >= arr.length) return;
		
		arr[index] = true;
		make2by3(arr, index+1, k+1);
		
		arr[index] = false;
		make2by3(arr, index+1, k);
	}
}
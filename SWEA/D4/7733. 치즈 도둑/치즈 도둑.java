import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int pieces;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] cheese = new int[N][N];
			int maxtaste = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					maxtaste = Math.max(cheese[i][j], maxtaste);
				}
			
			pieces = 0;
			for(int i = 0; i <= maxtaste; i++)
				afterNdays(cheese, i);
			
			System.out.println("#" + tc + " " + pieces);
		}
	}
	
	public static void afterNdays(int[][] arr, int day) {
		boolean[][] visit = new boolean[arr.length][arr.length];
		Queue<int[]> q = new LinkedList<>();
		int piece = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] > day && !visit[i][j]) {
					visit[i][j] = true;
					q.add(new int[] {i, j});
					piece++;
					
					while(!q.isEmpty()) {
						int[] check = q.poll();
						for(int dir = 0; dir < 4; dir++) {
							int x = check[0] + dx[dir];
							int y = check[1] + dy[dir];
							if(x < 0 || x >= arr.length || y < 0 || y >= arr.length)
								continue;
							if(arr[x][y] <= day || visit[x][y]) continue;
							q.add(new int[] {x, y});
							visit[x][y] = true;
						}
					}
				}
			}
		}
		pieces = Math.max(piece, pieces);
	}
}
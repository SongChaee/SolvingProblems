import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int N, W, H;
	public static int brickcnt;
	public static int min;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			int[][] map = new int[H][W];
			brickcnt = 0;
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < H; i++)
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) brickcnt++;
				}
			
			if(brickcnt - N <= 0) {
				System.out.println("#" + tc + " 0");
				continue;
			}
			
			bt(map, N, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void bt(int[][] arr, int n, int breakbrick) {
		if(n == 0 || breakbrick >= brickcnt) {
			min = Math.min(min, brickcnt - breakbrick);
			return;
		}
	
		for(int j = 0; j < W; j++) {
			for(int i = 0; i < H; i++) {
				if(arr[i][j] != 0) {
					int[][] copymap = copy(arr);
					int bricks = breakbrick;
					
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j, copymap[i][j]});
					copymap[i][j] = 0;
					bricks++;
					
					while(!q.isEmpty()) {
						int[] check = q.poll();
						
						for(int dir = 0; dir < 4; dir++) {
							int x = check[0];
							int y = check[1];
							int power = check[2];
							
							for(int p = 0; p < power - 1; p++) {
								x += dx[dir];
								y += dy[dir];
								
								if(x < 0 || x >= H || y < 0 || y >= W)
									continue;
								
								if(copymap[x][y] == 0) continue;
								
								q.add(new int[] {x, y, copymap[x][y]});
								copymap[x][y] = 0;
								bricks++;
							}
						}
					}
					gravity(copymap);
					bt(copymap, n-1, bricks);
					break;
				}
			}
		}
	}
	
	public static int[][] copy(int[][] arr) {
		int[][] c = new int[H][W];
		for(int i = 0; i < H; i++)
			c[i] = Arrays.copyOf(arr[i], W);
		return c;
	}
	
	public static void gravity(int[][] arr) {
		for(int j = 0; j < W; j++) {
			for(int i = H - 1; i >= 0; i--) {
				if(arr[i][j] == 0) {
					int ni = i;
					while(ni > 0 && arr[ni][j] == 0)
						ni--;
					arr[i][j] = arr[ni][j];
					arr[ni][j] = 0;
				}
			}
		}
	}
}
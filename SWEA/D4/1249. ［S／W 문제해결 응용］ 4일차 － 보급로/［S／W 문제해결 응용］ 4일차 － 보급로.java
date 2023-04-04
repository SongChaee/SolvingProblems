import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int N;
	public static int[][] map;
	public static int[][] dist;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N];
			for(int i = 0; i < N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			for(int i = 0; i < N; i++) {
				char[] input = sc.next().toCharArray();
				for(int j = 0; j < N; j++)
					map[i][j] = input[j] - '0';
			}
			
			sb.append("#").append(tc).append(" ");
			findMinPath();
		}
		System.out.print(sb.toString());
	}
	
	public static void findMinPath() {
		Queue<int[]> q = new LinkedList<>();
		
		dist[0][0] = 0;
		q.add(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] check = q.poll();
			if(check[2] != dist[check[0]][check[1]]) continue;
			
			for(int dir = 0; dir < 4; dir++) {
				int x = check[0] + dx[dir];
				int y = check[1] + dy[dir];
				
				if(x < 0 || x >= N || y < 0 || y >= N)
					continue;
				
				if(dist[x][y] <= dist[check[0]][check[1]] + map[x][y]) continue;
				
				dist[x][y] = dist[check[0]][check[1]] + map[x][y];
				q.add(new int[] {x, y, dist[x][y]});
			}
		}
		
		sb.append(dist[N-1][N-1]).append("\n");
	}
}
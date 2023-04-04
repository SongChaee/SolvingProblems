import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int len = sc.nextInt();
			int start = sc.nextInt();
			
			boolean[][] adj = new boolean[101][101];
			boolean[] visit = new boolean[101];
			
			for(int i = 0; i < len/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adj[from][to] = true;
			}
			
			Queue<int[]> q = new LinkedList<>();
			
			visit[start] = true;
			q.add(new int[] {start, 0});
			
			int[] time = new int[101];
			int endtime = 0;
			while(!q.isEmpty()) {
				int[] check = q.poll();
				endtime = check[1];
				time[check[1]] = Math.max(time[check[1]], check[0]);
				
				for(int i = 1; i <= 100; i++) {
					if(adj[check[0]][i] && !visit[i]) {
						visit[i] = true;
						q.add(new int[] {i, check[1] + 1});
					}
				}
			}
			sb.append(time[endtime]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
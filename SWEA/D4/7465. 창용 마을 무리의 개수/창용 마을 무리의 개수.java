import java.util.Scanner;

public class Solution {
	static int[] repre;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			repre = new int[N + 1];
			for(int i = 1; i <= N; i++)
				repre[i] = i;
			
			for(int i = 0; i < M; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				union(X, Y);
			}
			
			for(int i = 1; i <= N; i++)
				union(repre[i], i);
			
			boolean[] checked = new boolean[101];
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(!checked[repre[i]]) {
					checked[repre[i]] = true;
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	public static int findset(int x) {
		if(x != repre[x])
			repre[x] = findset(repre[x]);
		return repre[x];
	}
	
	public static void union(int x, int y) {
		repre[findset(y)] = findset(x);
	}
	
}
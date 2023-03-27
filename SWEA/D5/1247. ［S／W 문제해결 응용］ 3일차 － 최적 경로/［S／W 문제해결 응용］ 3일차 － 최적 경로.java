import java.util.Scanner;

public class Solution {
	static int[][] location;
	static int[] order;
	static boolean[] used;
	static int N;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			location = new int[N+2][2];
			
			for(int i = 0; i < N + 2; i++) {
				location[i][0] = sc.nextInt();
				location[i][1] = sc.nextInt();
			}
			
			order = new int[N];
			used = new boolean[N];
			min = Integer.MAX_VALUE;
			
			shortest(0);
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	public static void shortest(int index) {
		if(index == N) {
			int distance = 0;
			int[] idx = new int[N];
			for(int i = 0; i < N; i++)
				idx[order[i]] = i;
			for(int i = 0; i < N; i++) {
				int x = 0;
				int y = 0;
				if(i == 0) {
					x = Math.abs(location[idx[i]+2][0] - location[0][0]);
					y = Math.abs(location[idx[i]+2][1] - location[0][1]);
				} else {
					x = Math.abs(location[idx[i]+2][0] - location[idx[i-1]+2][0]);
					y = Math.abs(location[idx[i]+2][1] - location[idx[i-1]+2][1]);
					if(i == N - 1) {
						x += Math.abs(location[1][0] - location[idx[i]+2][0]);
						y += Math.abs(location[1][1] - location[idx[i]+2][1]);
					}
				}
				distance += x + y;
			}
			min = Math.min(min, distance);
		}
		
		for(int i = 0; i < N; i++) {
			if(!used[i]) {
				used[i] = true;
				order[index] = i;
				shortest(index + 1);
				used[i] = false;
			}
		}
	}	
}
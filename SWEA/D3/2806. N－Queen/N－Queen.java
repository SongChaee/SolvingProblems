import java.util.Scanner;

public class Solution {
	static int N = 10;
	static boolean[] col = new boolean[10];
	static boolean[] dia1 = new boolean[19];
	static boolean[] dia2 = new boolean[19];
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			col = new boolean[N];
			dia1 = new boolean[N*2 - 1];
			dia2 = new boolean[N*2 - 1];
			cnt = 0;
			NQueen(0);
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	public static void NQueen(int row) {
		if(row == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!col[i] && !dia1[i+row] && !dia2[i-row+N-1]) {
				col[i] = true;
				dia1[i+row] = true;
				dia2[i-row+N-1] = true;
				NQueen(row + 1);
				
				col[i] = false;
				dia1[i+row] = false;
				dia2[i-row+N-1] = false;
			}
		}
	}
}
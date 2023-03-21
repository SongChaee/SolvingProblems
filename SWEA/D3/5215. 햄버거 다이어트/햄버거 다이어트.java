import java.util.Scanner;

public class Solution {
	static int best = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int limit = sc.nextInt();
			boolean[] ingredient = new boolean[N];
			int[] score = new int[N];
			int[] cal = new int[N];
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			best = 0;
			recur(limit, ingredient, score, cal, 0);
			System.out.printf("#%d %d\n", tc, best);
		}
	}
	
	public static void recur(int limit, boolean[] ingredient, int[] score, int[] cal, int idx) {
		if(idx == score.length) {
			int calsum = 0;
			for(int i = 0; i < score.length; i++)
				if(ingredient[i])
					calsum += cal[i];
			if(calsum <= limit) {
				int scoresum = 0;
				for(int i = 0; i < score.length; i++)
					if(ingredient[i])
						scoresum += score[i];
				if(scoresum > best) best = scoresum;
			}
			return;
		}
		
		ingredient[idx] = true;
		recur(limit, ingredient, score, cal, idx+1);
		
		ingredient[idx] = false;
		recur(limit, ingredient, score, cal, idx+1);
	}
}
import java.util.Scanner;

public class Solution {
	static int N;
	static boolean[] selIngredient;
	static int Asynergy = 0;
	static int Bsynergy = 0;
	static int[][] synergy;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			selIngredient = new boolean[N];
			synergy = new int[N][N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					synergy[i][j] = sc.nextInt();
			
			combiIngredient(selIngredient, 0, 0);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	public static void combiIngredient(boolean[] sel, int idx, int k) {
		if(k == N/2) {
			int[] Apick = new int[N/2];
			int[] Bpick = new int[N/2];
			int Aidx = 0;
			int Bidx = 0;
			Asynergy = 0;
			Bsynergy = 0;
			
			for(int i = 0; i < N; i++) {
				if(sel[i]) Apick[Aidx++] = i;
				else Bpick[Bidx++] = i;
			}
			
			synergy(true, new boolean[N/2], Apick, 0, 0);
			synergy(false, new boolean[N/2], Bpick, 0, 0);
			
			int gap = Math.abs(Asynergy - Bsynergy);
			min = Math.min(gap, min);
			
			return;
		}
		if(idx >= sel.length) return;
		
		sel[idx] = true;
		combiIngredient(sel, idx+1, k+1);
		
		sel[idx] = false;
		combiIngredient(sel, idx+1, k);
	}
	
	public static void synergy(boolean AorB, boolean[] sel, int[] arr, int idx, int k) {
		if(k == 2) {
			int[] ingredient = new int[2];
			int Iidx = 0;
			for(int i = 0; i < arr.length; i++)
				if(sel[i]) ingredient[Iidx++] = arr[i];
			if(AorB) Asynergy += synergy[ingredient[0]][ingredient[1]] + synergy[ingredient[1]][ingredient[0]];
			else Bsynergy += synergy[ingredient[0]][ingredient[1]] + synergy[ingredient[1]][ingredient[0]];
			
			return;
		}
		if(idx >= arr.length) return;
		
		sel[idx] = true;
		synergy(AorB, sel, arr, idx+1, k+1);
		
		sel[idx] = false;
		synergy(AorB, sel, arr, idx+1, k);
	}
}
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static boolean[] cards = new boolean[19];
	static int[] A = new int[9];
	static int[] B = new int[9];
	static boolean[] Bused = new boolean[9];
	static int[] Bperm = new int[9];
	static int Ascore = 0;
	static int Bscore = 0;
	static int Awin = 0;
	static int Alose = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			cards = new boolean[19];
			for(int i = 0; i < 9; i++) {
				A[i] = sc.nextInt();
				cards[A[i]] = true;
			}
			
			int idx = 0;
			for(int i = 1; i < 19; i++)
				if(!cards[i])
					B[idx++] = i;
			Bused = new boolean[9];
			Bperm = new int[9];
			Awin = 0;
			Alose = 0;
			
			perm(0);
			System.out.printf("#%d %d %d\n", tc, Awin, Alose);
		}
	}
	
	public static void perm(int index) {
		if(index == 9) {
			score();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(Bused[i]) continue;
			
			Bperm[index] = B[i];
			Bused[i] = true;
			perm(index + 1);
			Bused[i] = false;
		}
	}
	
	public static void score() {
		Ascore = 0;
		Bscore = 0;
		for(int i = 0; i < 9; i++) {
			int Acard = A[i];
			int Bcard = Bperm[i];
			if(Acard > Bcard)
				Ascore += Acard + Bcard;
			else
				Bscore += Acard + Bcard;
		}
		if(Ascore > Bscore)
			Awin++;
		else if(Bscore > Ascore)
			Alose++;
	}
}
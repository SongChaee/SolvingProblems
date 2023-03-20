import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(binary(N, M))
				System.out.printf("#%d ON\n", tc);
			else
				System.out.printf("#%d OFF\n", tc);
		}
	}
	
	static boolean binary(int N, int M) {
		while(N > 0) {
			if(M % 2 == 1) {
				N--;
				M = M/2;
			}
			else
				return false;
		}
		return true;
	}
}
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.printf("#%d %d\n", tc, recur(N, M));
		}
	}
	
	public static int recur(int N, int M) {
		if(M == 1) return N;
		
		int result = recur(N, M/2);
		if(M % 2 == 0)
			return result * result;
		else 
			return result * result * N;
	}
}
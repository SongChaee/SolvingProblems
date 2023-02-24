import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for(int x = 0; x < N; x++) {
				char[] input = sc.next().toCharArray();
				for(int y = 0; y < N; y++) {
					farm[x][y] = input[y] - '0';
				}
			}
			
			int start = N/2;
			int end = N/2;
			int sum = 0;
			for(int x = 0; x < N / 2; x++) {
				for(int y = start; y <= end; y++)
					sum += farm[x][y];
				start--;
				end++;
			}
			
			for(int x = N / 2; x < N; x++) {
				for(int y = start; y <= end; y++)
					sum += farm[x][y];
				start++;
				end--;
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
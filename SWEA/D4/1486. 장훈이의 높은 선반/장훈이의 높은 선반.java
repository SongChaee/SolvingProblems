import java.util.Scanner;

public class Solution {
	static int N, B;
	static int[] arr;
	static boolean[] used;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			arr = new int[N];
			used = new boolean[N];
			int idx = 0;
			for(int i = 0; i < N; i++)
				arr[idx++] = sc.nextInt();
			
			min = Integer.MAX_VALUE;
			recur(0);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	static void recur(int index) {
		if(index == N) {
			int sum = 0;
			for(int i = 0; i < N; i++)
				if(used[i])
					sum += arr[i];
			if(sum >= B)
				min = Math.min(min, sum - B);
			return;
		}
		
		used[index] = true;
		recur(index + 1);
		
		used[index] = false;
		recur(index + 1);
	}
}
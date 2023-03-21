import java.util.Scanner;

public class Solution {
	static int[] arr;
	static boolean[] used;
	static int cnt = 0;
	
	static int N, S;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			S = sc.nextInt();
			
			arr = new int[N];
			used = new boolean[N];
			cnt = 0;
			for(int n = 0; n < N; n++)
				arr[n] = sc.nextInt();
			
			part(0);
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	static void part(int idx) {
		if(idx == N) {
			if(allfalse(used)) return;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(used[i]) {
					sum += arr[i];
				}
			}
			if(sum == S) cnt++;
			return;
		}
		
		used[idx] = true;
		part(idx + 1);
		
		used[idx] = false;
		part(idx + 1);
	}
	
	static boolean allfalse(boolean[] arr) {
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == true)
				return false;
		return true;
	}
}
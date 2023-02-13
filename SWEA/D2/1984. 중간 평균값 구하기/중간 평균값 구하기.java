import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			int[] arr = new int[10];
			for(int j = 0; j < 10; j++)
				arr[j] = sc.nextInt();
			
			int min = arr[0];
			int max = arr[0];
			int sum = arr[0];
			for(int k = 1; k < 10; k++) {
				if(arr[k] > max) max = arr[k];
				if(arr[k] < min) min = arr[k];
				sum += arr[k];
			}
			sum = sum - max - min;
			System.out.printf("#%d %.0f\n", i, (float) sum/8);
		}
	}
}
import java.util.Scanner;

public class Solution {
    static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(sc.nextLine());
			int log = (int) (Math.log(N) / Math.log(2));
			char[] arr = new char[(int) Math.pow(2, log + 1)];
			
			for(int i = 1; i <= N; i++) {
				int idx = sc.nextInt();
				String str = sc.nextLine();
				arr[i] = str.charAt(1);
			}
			
			System.out.printf("#%d ", tc);
			inorderTraverse(1, arr);
			System.out.println();
		}
	}
	
	static void inorderTraverse(int i, char[] arr) {
		if(i <= N) {
			inorderTraverse(i * 2, arr);
			if(arr[i] != '\u0000')
				System.out.print(arr[i]);
			inorderTraverse(i * 2 + 1, arr);
		}
	}
}
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			char[][] arr = new char[N][N];
			for(int n = 0; n < N; n++) {
				arr[n] = sc.next().toCharArray();
			}
			
			if(row(arr) || col(arr) || dia1(arr) || dia2(arr))
				System.out.printf("#%d YES\n", tc);
			else
				System.out.printf("#%d NO\n", tc);
		}
	}
	
	static boolean row(char[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			
			int cnt = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 'o') cnt++;
				else cnt = 0;
				if(cnt >= 5) return true;
			}
		}
		return false;
	}
	
	static boolean col(char[][] arr) {
		for(int j = 0; j < arr.length; j++) {
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i][j] == 'o') {
					cnt++;
					if(cnt >= 5) return true;
				}
				else cnt = 0;
			}
		}
		return false;
	}
	
	static boolean dia1(char[][] arr) {
		for(int i = 0; i < arr.length - 4; i++) {
			for(int j = 0; j < arr.length - 4; j++) {
				if(arr[i][j] == 'o' && arr[i+1][j+1] == 'o' && arr[i+2][j+2] == 'o' && arr[i+3][j+3] == 'o' && arr[i+4][j+4] == 'o')
					return true;
			}
		}
		return false;
	}
	
	static boolean dia2(char[][] arr) {
		for(int i = 0; i < arr.length - 4; i++) {
			for(int j = arr.length - 1; j >= 4; j--) {
				if(arr[i][j] == 'o' && arr[i+1][j-1] == 'o' && arr[i+2][j-2] == 'o' && arr[i+3][j-3] == 'o' && arr[i+4][j-4] == 'o')
					return true;
			}
		}
		return false;
	}
}
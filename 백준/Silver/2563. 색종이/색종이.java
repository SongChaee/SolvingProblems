import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean[][] arr = new boolean[100][100];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r = x; r < x + 10; r++) {
				for(int c = y; c < y + 10; c++)
					if(!arr[r][c]) arr[r][c] = true;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++)
				if(arr[i][j]) cnt++;
		}
		
		System.out.println(cnt);
	}
}

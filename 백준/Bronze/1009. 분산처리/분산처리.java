import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수
		int T = sc.nextInt();
		
		int a = 0;
		int b = 0;
		int il = 0;
		int computer = 0;
		
		// 각 테스트별 데이터 개수, 총 데이터 수 : a^b개
		for(int i = 0; i < T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			il = a % 10;
			
			if(il == 0) {
				computer = 10;
			} else {
				for(int j = 1; j < b; j++)
					il = (il * a) % 10;
				computer = il;
			}
			System.out.println(computer);
		}
	}
}
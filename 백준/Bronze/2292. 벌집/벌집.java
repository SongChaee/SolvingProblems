import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = 1;
		int room = 1;
		if(N == 1)
			System.out.print(room);
		else {
			for(int i = 1; sum < N; i++) {
				sum += 6 * i;
				room++;
			}
			System.out.print(room);
		}
	}
}
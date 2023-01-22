import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] element = new String[2];
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < T; i++) {
			String test = sc.nextLine();
			element = test.split(",");
			System.out.println(Integer.parseInt(element[0]) + Integer.parseInt(element[1]));
		}
	}
}
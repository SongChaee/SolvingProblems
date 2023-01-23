import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] text = new String[input.length()];
		text = input.split("");
		
		for(int i = 0; i < (input.length()/10) + 1; i++) {
			for(int j = 0; j < 10; j++) {
				if(10*i+j >= input.length()) break;
				else System.out.print(text[10*i+j]);
			}
			System.out.println();
		}
		sc.close();
	}
}
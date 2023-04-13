import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int five = 0;
		int three = 0;
		int rest = N % 5;
		int ans = 0;
		boolean flag = false;
		
		five = N / 5;
		if(rest % 3 == 0) {
			three = rest / 3;
		}else {
			while(rest % 3 != 0) {
				rest += 5;
				five--;
				three = rest / 3;
				if(five < 0) {
					flag = true;
					break;
				}
			}
		}
		
		ans = five + three;
		if(flag) System.out.print("-1");
		else System.out.print(ans);
	}
}
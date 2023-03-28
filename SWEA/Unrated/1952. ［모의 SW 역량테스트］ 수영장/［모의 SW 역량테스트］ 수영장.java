import java.util.Scanner;

public class Solution {
	static int minfee;
	static int[] ticketprice = new int[4];
	static int[] monthly = new int[13];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			for(int i = 0; i < 4; i++)
				ticketprice[i] = sc.nextInt();
			
			for(int i = 1; i <= 12; i++)
				monthly[i] = sc.nextInt();
			
			minfee = Integer.MAX_VALUE;
			ticket(1, 0);
			System.out.println("#" + tc + " " + minfee);
		}
	}
	
	public static void ticket(int month, int fee) {
		if(month > 12) {
			minfee = Math.min(fee, minfee);
			return;
		}
		if(monthly[month] == 0)
			ticket(month + 1, fee);
		else {
			ticket(month + 1, fee + monthly[month] * ticketprice[0]);
			ticket(month + 1, fee + ticketprice[1]);
			ticket(month + 3, fee + ticketprice[2]);
			ticket(month + 12, fee + ticketprice[3]);
		}
	}
}
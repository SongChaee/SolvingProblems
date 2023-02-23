import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int casenum = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i= 0; i < 8; i++) {
				int value = sc.nextInt();
				q.add(value);
			}
			
			int minus = 1;
			while(true) {
				int check = q.poll();
				int value = check - minus;
				if(value < 0) value = 0;
				q.add(value);
				if(value == 0) break;
				minus++;
				if(minus > 5) minus = 1;
			}
				
			System.out.printf("#%d ", casenum);
			while(!q.isEmpty())
				System.out.print(q.poll() + " ");
			System.out.println();
		}
	}
}
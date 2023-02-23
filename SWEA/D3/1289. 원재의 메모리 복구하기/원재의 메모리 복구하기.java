import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
            Queue<Character> in = new LinkedList<>();
			boolean flag = false;
			int flagcnt = 0;
			
            char[] input = sc.next().toCharArray();
			for(int i = 0; i < input.length; i++) {
				in.add(input[i]);
			}
            
			for(int i = 0; i < input.length; i++) {
				char a = in.poll();
				
				if(!flag && a != '0') {
					flag = !flag;
					flagcnt++;
				}else if(flag && a == '0') {
					flag = !flag;
					flagcnt++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, flagcnt);
		}
	}
}
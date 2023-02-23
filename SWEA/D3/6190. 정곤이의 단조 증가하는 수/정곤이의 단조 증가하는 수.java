import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] input = new int[N];
			
			for(int i = 0; i < N; i++)
				input[i] = sc.nextInt();
			
			PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
			for(int i = 0; i < N - 1; i++)
				for(int j = i + 1; j < N; j++)
					q.add(input[i] * input[j]);
			
			boolean flag = false;
			boolean isIncrease = true;;
			int result = 0;
			while(!q.isEmpty()) {
				int check = q.poll();
				char[] number = ("" + check).toCharArray();
				if(number.length == 1) {
					flag = true;
					break;
				}else {
					for(int i = number.length - 1; i > 0; i--) {
						isIncrease = true;
						if(number[i]-'0' < number[i-1]-'0') {
							isIncrease = false;
							break;
						}
					}
					if(isIncrease) {
						result = check;
						break;
					}
				}
			}
			
			if(q.isEmpty() || flag)
				System.out.printf("#%d -1\n", tc);
			else
				System.out.printf("#%d %d\n", tc, result);
		}
	}
}

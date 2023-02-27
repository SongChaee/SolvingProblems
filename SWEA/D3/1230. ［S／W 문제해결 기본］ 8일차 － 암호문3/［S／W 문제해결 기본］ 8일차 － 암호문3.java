import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> code = new LinkedList<>();
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			code = new LinkedList<>();
			int N = sc.nextInt();
			for(int n = 0; n < N; n++)
				code.add(sc.nextInt());
			
			int commN = sc.nextInt();
			for(int n = 0; n < commN; n++) {
				char comm = sc.next().charAt(0);
				if(comm == 'I') {
					int pos = sc.nextInt();
					int num = sc.nextInt();
					for(int i = 0; i < num; i++)
						code.add(pos++, sc.nextInt());
				}else if(comm == 'D') {
					int pos = sc.nextInt();
					int num = sc.nextInt();
					for(int i = 0; i < num; i++)
						code.remove(pos);
				}else if(comm == 'A') {
					int num = sc.nextInt();
					for(int i = 0; i < num; i++)
						code.add(sc.nextInt());
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++)
				System.out.print(code.get(i) + " ");
			System.out.println();
		}
	}
}
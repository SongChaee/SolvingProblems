import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			for(int n = 0; n < N; n++) {
				int pos = 0;
				int num = sc.nextInt();
				if(list.size() == 0)
					list.add(num);
				else if(list.size() == 1) {
					if(num > list.get(0))
						list.add(num);
					else
						list.addFirst(num);
				}
				else{
					for(int i = 1; i < list.size(); i++) {
						if(num < list.get(0)) {
							pos = 0;
							break;
						}
						else if(list.get(i) < num)
							pos = i + 1;
						else if(list.get(i-1) <= num && num <= list.get(i))
							pos = i;
					}
					list.add(pos, num);
				}
			}
			System.out.printf("#%d ", tc);
			for(int i = 0; i < N; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
		}
	}
}
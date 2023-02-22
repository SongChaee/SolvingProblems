import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		Queue<String> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			int len = Integer.parseInt(sc.nextLine());
			String[] card = sc.nextLine().split(" ");
			for(int i = 0; i < card.length; i++)
				q.add(card[i]);
			
			while(!q.isEmpty()) {
				int size = q.size();
				if(size % 2 == 0) {
					for(int i = 0; i < 2; i++ ) {
						sb.append(q.poll() + " ");
						for(int j = 0; j < size / 2 - 1; j++) {
							q.add(q.poll());
						}
					}
				} else {
					sb.append(q.poll() + " ");
					if(q.isEmpty()) break;
					for(int j = 0; j < size / 2; j++)
						q.add(q.poll());
					sb.append(q.poll() + " ");
					for(int k = 0; k < size / 2 - 1; k++)
						q.add(q.poll());
				}
			}
			System.out.println(sb.toString());
		}
	}
}
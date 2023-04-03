import java.util.Scanner;

public class Solution {
	public static int[] p;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = sc.nextInt();
			p = new int[N + 1];
			for(int i = 1; i < p.length; i++)
				p[i] = i;
			
			int comm = sc.nextInt();
			for(int c = 0; c < comm; c++) {
				int option = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(option == 0) {
					union(x, y);
				}else {
					if(findset(x) == findset(y))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static int findset(int x) {
		if(x != p[x]){
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	
	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
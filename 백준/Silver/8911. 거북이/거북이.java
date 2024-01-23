import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int dir;
	public static String order;
	public static int x, xmin, xmax, y, ymin, ymax;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			order = br.readLine();
			dir = 500;
			x = 0; xmin = 0; xmax = 0; y = 0; ymin = 0; ymax = 0;
			
			move();
			int ans = (xmax - xmin) * (ymax - ymin);
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void move() {
		for(int i = 0; i < order.length(); i++) {
			char c = order.charAt(i);
			if(c == 'F') {
				x += dx[dir % 4];
				y += dy[dir % 4];
				renew();
			}
			else if(c == 'B') {
				x += dx[(dir + 2) % 4];
				y += dy[(dir + 2) % 4];
				renew();
			}
			else if(c == 'L')
				dir--;
			else if(c == 'R')
				dir++;
		}
	}
	
	public static void renew() {
		xmin = Math.min(x, xmin);
		xmax = Math.max(x, xmax);
		ymin = Math.min(y, ymin);
		ymax = Math.max(y, ymax);
	}
}
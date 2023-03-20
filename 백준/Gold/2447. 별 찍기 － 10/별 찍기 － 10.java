import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] pattern;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pattern = new char[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				pattern[i][j] = ' ';
		
		recur(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				sb.append(pattern[i][j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void recur(int startx, int starty, int size) {
		if(size == 3) {
			for(int i = startx; i < startx + size; i++) {
				for(int j = starty; j < starty + size; j++) {
					if(i == startx + 1 && j == starty + 1)
						pattern[i][j] = ' ';
					else
						pattern[i][j] = '*';
				}
			}
			return;	
		}
		
		recur(startx, starty, size/3);
		recur(startx, starty + size/3, size/3);
		recur(startx, starty + size/3*2, size/3);
		recur(startx + size/3, starty, size/3);
		recur(startx + size/3, starty + size/3*2, size/3);
		recur(startx + size/3*2, starty, size/3);
		recur(startx + size/3*2, starty + size/3, size/3);
		recur(startx + size/3*2, starty + size/3*2, size/3);
	}
}
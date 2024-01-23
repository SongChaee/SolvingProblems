import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[][] visit = new boolean[M][N];
		int total = M * N;
		int temp = 1;
		int ans = 0;
		visit[0][0] = true;
		int x = 0;
		int y = 1;

		while(true) {
			// → 이동
			while(y < N && !visit[x][y]) {
				visit[x][y] = true;
				y++;
				temp++;
			}
			if(temp == total) break;
			ans++;
			
			// ↓ 이동
			y--; x++;
			while(x < M && !visit[x][y]) {
				visit[x][y] = true;
				x++;
				temp++;
			}
			if(temp == total) break;
			ans++;
			
			// ← 이동
			x--; y--;
			while(y >= 0 && !visit[x][y]) {
				visit[x][y] = true;
				y--;
				temp++;
			}
			if(temp == total) break;
			ans++;
			
			// ↑ 이동
			y++; x--;
			while(x >= 0 && !visit[x][y]) {
				visit[x][y] = true;
				x--;
				temp++;
			}
			if(temp == total) break;
			ans++;
			
			x++; y++;
		}
		
		System.out.print(ans);
	}
}
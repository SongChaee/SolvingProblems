import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static HashMap<String, Integer> hash;
	public static char[][] map;
	public static int N, M, K;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		hash = new HashMap<>();
		String input;
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = input.charAt(j);
				map[i][j] = c;
				hash.put(Character.toString(c), hash.getOrDefault(c, 0) + 1);
			}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				for(int len = 2; len <= 5; len++)
					findAll(Character.toString(map[i][j]), i, j, len, 1);
		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < K; k++) {
			input = br.readLine();
			sb.append(hash.getOrDefault(input, 0)).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void findAll(String st, int x, int y, int len, int idx) {
		if(len == idx) {
			hash.put(st, hash.getOrDefault(st, 0) + 1);
			return;
		}
		
		for(int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx < 0) nx = N - 1;
			else if(nx >= N) nx = 0;
			if(ny < 0) ny = M - 1;
			else if(ny >= M) ny = 0;
			
			String next = st + map[nx][ny];
			findAll(next, nx, ny, len, idx + 1);
		}
	}
}
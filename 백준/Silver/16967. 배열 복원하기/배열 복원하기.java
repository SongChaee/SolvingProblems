import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H + X][W + Y];
		for(int h = 0; h < H + X; h++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int w = 0; w < W + Y; w++)
				map[h][w] = Integer.parseInt(st.nextToken());
		}
		
		int[][] origin = new int[H][W];
		for(int h = 0; h < H + X; h++) {
			for(int w = 0; w < W + Y; w++) {
				if(h < X && w < W)
					origin[h][w] = map[h][w];
				else if(h < H && w < Y)
					origin[h][w] = map[h][w];
				else if(h >= X && h < H && w >= Y && w < W)
					origin[h][w] = map[h][w] - origin[h - X][w - Y];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++)
				sb.append(origin[h][w]).append(" ");
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
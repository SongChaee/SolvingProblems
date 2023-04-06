import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] x = new int[6];
		int[] y = new int[6];
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int dir;
		int move;
		int curx = 0;
		int cury = 0;
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			move = Integer.parseInt(st.nextToken());
			if(dir == 1) {
				x[i] = curx + move;
				y[i] = cury;
			} else if(dir == 2) {
				x[i] = curx - move;
				y[i] = cury;
			} else if(dir == 3) {
				x[i] = curx;
				y[i] = cury - move;
			} else {
				x[i] = curx;
				y[i] = cury + move;
			}
			curx = x[i];
			cury = y[i];
		}
		
		int maxx = x[0];
		int minx = x[0];
		int maxy = y[0];
		int miny = y[0];
		for(int i = 1; i < 6; i++) {
			maxx = Math.max(maxx, x[i]);
			minx = Math.min(minx, x[i]);
			maxy = Math.max(maxy, y[i]);
			miny = Math.min(miny, y[i]);
		}
		
		boolean[] notuse = new boolean[6];
		for(int i = 0; i < 6; i++) {
			if(x[i] == maxx && y[i] == maxy) notuse[i] = true;
			if(x[i] == maxx && y[i] == miny) notuse[i] = true;
			if(x[i] == minx && y[i] == maxy) notuse[i] = true;
			if(x[i] == minx && y[i] == miny) notuse[i] = true;
		}
		
		int[] usex = new int[3];
		int[] usey = new int[3];
		int index = 0;
		for(int i = 0; i < 6; i++) {
			if(!notuse[i]) {
				usex[index] = x[i];
				usey[index++] = y[i];
			}
		}
		
		int smallrectx = Math.abs(usex[0] - usex[2]);
		int smallrecty = Math.abs(usey[0] - usey[2]);
		for(int i = 1; i < 3; i++) {
			smallrectx = Math.max(smallrectx, Math.abs(usex[i] - usex[i-1]));
			smallrecty = Math.max(smallrecty, Math.abs(usey[i] - usey[i-1]));
		}
		int smallrect = smallrectx * smallrecty;
		
		int bigrect = Math.abs(maxx - minx) * Math.abs(maxy - miny);
		
		int ans = K * (bigrect - smallrect);
		
		System.out.println(ans);
	}
}
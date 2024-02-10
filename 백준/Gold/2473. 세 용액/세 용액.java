import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] value;
	static long[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		value = new int[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++)
			value[n] = Integer.parseInt(st.nextToken());
		Arrays.sort(value);
		
		ans = new long[4];
		ans[3] = Long.MAX_VALUE;
		
		for(int i = 0; i < N - 2; i++) {
			find(i);
			if(ans[3] == 0) break;
		}
		
		System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);
	}
	
	public static void find(int pt) {
		int pt1 = pt + 1;
		int pt2 = N - 1;
		
		while(pt1 < pt2) {
			long add = (long) value[pt] + value[pt1] + value[pt2];
			
			if(ans[3] > Math.abs(add)) {
				ans[0] = value[pt];
				ans[1] = value[pt1];
				ans[2] = value[pt2];
				ans[3] = Math.abs(add);
			}
			
			if(add < 0)
				pt1++;
			else if(add > 0)
				pt2--;
			else {
				break;
			}
		}
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++)
			value[n] = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[3];
		ans[2] = Integer.MAX_VALUE;
		int pt1 = 0;
		int pt2 = N - 1;
		
		while(pt1 < pt2) {
			int add = value[pt1] + value[pt2];
			if(Math.abs(add) < ans[2]) {
				ans[0] = value[pt1];
				ans[1] = value[pt2];
				ans[2] = Math.abs(add);
			}
			
			if(add > 0) pt2--;
			else if(add < 0) pt1++;
			else {
				ans[0] = value[pt1];
				ans[1] = value[pt2];
				break;
			}
		}
		
		System.out.print(ans[0] + " " + ans[1]);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[] bus = new int[5001];
			
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int ai = Integer.parseInt(st.nextToken());
				int bi = Integer.parseInt(st.nextToken());
				for(int i = ai; i <= bi; i++)
					bus[i]++;
			}
			
			StringBuilder sb = new StringBuilder();
			int P = Integer.parseInt(br.readLine());
			for(int p = 0; p < P; p++) {
				int ci = Integer.parseInt(br.readLine());
				sb.append(bus[ci] + " ");
			}
			
			System.out.printf("#%d ", tc);
			System.out.println(sb.toString());
		}
	}
}
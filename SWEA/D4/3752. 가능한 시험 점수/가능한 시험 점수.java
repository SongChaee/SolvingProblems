import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] score = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			int max = 0;
			boolean[] result = new boolean[10001];
			result[0] = true;
			for(int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				max += score[i];
				
				for(int j = max; j >= 0; j--) {
					if(result[j])
						result[j + score[i]] = true;
				}
			}
			
			int ans = 0;
			for(int i = 0; i <= 10000; i++)
				if(result[i])
					ans++;
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		
		System.out.print(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] value = new int[N];
		int[] score = new int[1000001];
		boolean[] card = new boolean[1000001];
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++) {
			value[n] = Integer.parseInt(st.nextToken());
			card[value[n]] = true;
			max = Math.max(max, value[n]);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = value[i] * 2; j <= max; j += value[i]) {
				if(card[j]) {
					score[value[i]]++;
					score[j]--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(score[value[i]]).append(" ");
		System.out.print(sb.toString());
	}
}

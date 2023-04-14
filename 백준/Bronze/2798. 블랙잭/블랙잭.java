import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] cards;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		cards = new int[N];
		for(int n = 0; n < N; n++)
			cards[n] = Integer.parseInt(st.nextToken());
		
		boolean[] used = new boolean[N];
		combi(used, 0, 0);
		
		System.out.print(max);
	}
	
	public static void combi(boolean[] used, int index, int k) {
		if(k == 3) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(used[i])
					sum += cards[i];
			}
			if(sum <= M)
				max = Math.max(max, sum);
			
			return;
		}
		if(index >= N) return;
		
		used[index] = true;
		combi(used, index + 1, k + 1);
		
		used[index] = false;
		combi(used, index + 1, k);
	}
}
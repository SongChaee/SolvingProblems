import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int plate, N, K, coupon;
	static int[] sushi;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		plate = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		
		sushi = new int[plate];
		for(int i = 0; i < plate; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < plate; i++)
			choose(i);
		
		System.out.print(ans);
	}
	
	public static void choose(int startIdx) {
		boolean[] choice = new boolean[3001];
		int result = 0;
		
		for(int i = startIdx; i < startIdx + K; i++) {
			int idx = i % plate;
			if(!choice[sushi[idx]]) {
				choice[sushi[idx]] = true;
				result++;
			}
		}
		
		if(!choice[coupon])
			result++;
		
		ans = Math.max(ans, result);
	}
}
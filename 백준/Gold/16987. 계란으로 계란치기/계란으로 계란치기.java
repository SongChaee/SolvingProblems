import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] weight;
	public static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] endure = new int[N];
		weight = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			endure[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		boolean[] isBroken = new boolean[N];
		if(endure[0] <= 0) isBroken[0] = true;
		hit(0, isBroken, 0, endure);
		
		System.out.print(max);
		br.close();
	}
	
	public static void hit(int nowIdx, boolean[] broken, int brokenN, int[] nowEndure) {
		
		if(nowIdx == N || brokenN == N - 1) {
			max = Math.max(brokenN, max);
			return;
		}
		if(broken[nowIdx]) {
			hit(nowIdx + 1, broken, brokenN, nowEndure);
		}
		
		for(int i = 0; i < N; i++) {
			if(broken[nowIdx]) continue;
			if(nowIdx == i) continue;
			if(broken[i]) continue;
			nowEndure[nowIdx] -= weight[i];
			nowEndure[i] -= weight[nowIdx];
			if(nowEndure[nowIdx] <= 0) {
				broken[nowIdx] = true;
			}
			if(nowEndure[i] <= 0) {
				broken[i] = true;
			}
			
			int result = 0;
			for(int r = 0; r < N; r++)
				if(broken[r]) result++;
			hit(nowIdx + 1, broken, result, nowEndure);
			
			nowEndure[nowIdx] += weight[i];
			nowEndure[i] += weight[nowIdx];
			if(nowEndure[nowIdx] > 0) {
				broken[nowIdx] = false;
			}
			if(nowEndure[i] > 0) {
				broken[i] = false;
			}
		}
	}
}

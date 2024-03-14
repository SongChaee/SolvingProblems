import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] map = new int[W];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < W; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i = 1; i < W - 1; i++) {
			int left = 0;
			for(int j = 0; j < i; j++)
				left = Math.max(map[j], left);
			
			int right = 0;
			for(int j = i + 1; j < W; j++)
				right = Math.max(map[j], right);
			
			if(map[i] < left && map[i] < right)
				sum += Math.min(left, right) - map[i];
		}
		
		System.out.print(sum);
	}
}
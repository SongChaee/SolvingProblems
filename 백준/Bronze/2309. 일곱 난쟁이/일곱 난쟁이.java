import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] height = new int[9];
	static int[] real = new int[7];
	static boolean[] used = new boolean[9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++)
			height[i] = Integer.parseInt(br.readLine());
		
		findreal(0, 0);
		
		StringBuilder sb = new StringBuilder();
		Arrays.sort(real);
		for(int i = 0; i < 7; i++)
			sb.append(real[i]).append("\n");
		System.out.print(sb.toString());
	}
	
	public static void findreal (int idx, int k) {
		if(k == 7) {
			int sum = 0;
			for(int i = 0; i < 9; i++) {
				if(used[i])
					sum += height[i];
			}
			if(sum == 100) {
				int index = 0;
				for(int i = 0; i < 9; i++)
					if(used[i])
						real[index++] = height[i];
			}
			return;
		}
		if(idx >= 9) return;
		
		used[idx] = true;
		findreal(idx + 1, k + 1);
		
		used[idx] = false;
		findreal(idx + 1, k);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		int[] n = new int[11];
		n[1] = 1;
		n[2] = 2;
		n[3] = 4;
		for(int i = 4; i <= 10; i++)
			n[i] = n[i-1] + n[i-2] + n[i-3];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int a;
		for(int tc = 0; tc < T; tc++) {
			a = Integer.parseInt(br.readLine());
			sb.append(n[a]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
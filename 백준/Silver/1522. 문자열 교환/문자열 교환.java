import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		char[] input = str.toCharArray();

		int alen = 0;
		for (int i = 0; i < input.length; i++)
			if (input[i] == 'a')
				alen++;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			int bcnt = 0;
			for (int j = i; j < i + alen; j++) {
				if (input[j % input.length] == 'b')
					bcnt++;
			}
			ans = Math.min(ans, bcnt);
		}
		
		System.out.print(ans);
	}
}
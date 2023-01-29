import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int[] ans = new int[N+1];
		
		for(int i = 2; i <= N; i++) {
            ans[i] = ans[i - 1] + 1;
			if(i % 2 == 0)
				ans[i] = Math.min(ans[i / 2] + 1, ans[i]);
			if(i % 3 == 0)
				ans[i] = Math.min(ans[i / 3] + 1, ans[i]);
		}
		
		bw.write(ans[N] + "");
		
		bw.flush();
		bw.close();
	}
}
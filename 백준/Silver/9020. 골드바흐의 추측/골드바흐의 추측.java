import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = 10000;
		boolean[] prime = new boolean[N + 1];
		for(int i = 2; i <= N; i++)
			prime[i] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++)
			for(int j = i + i; j <= N; j += i)
				prime[j] = false;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			int testcase = Integer.parseInt(br.readLine());
			for(int j = testcase / 2; j >= 2; j--) {
				if(prime[j] && prime[testcase-j]) {
					bw.write(j + " " + (testcase - j) + "\n");
					break;
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
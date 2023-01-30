import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bw.write(Eratos(N, K) + "");
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int Eratos(int N, int K) {
		boolean[] num = new boolean[N+1];
		for(int i = 2; i <= N; i++)
			num[i] = true;
		
		for(int i = 2; i <= N; i++)
			if(num[i]) {
				num[i] = false;
				K--;
				if(K <= 0) return i;
				for(int j = i + i; j <= N; j += i)
					if(num[j]) {
						num[j] = false;
						K--;
						if(K <= 0) return j;
					}
			}
		return 0;
	}
}

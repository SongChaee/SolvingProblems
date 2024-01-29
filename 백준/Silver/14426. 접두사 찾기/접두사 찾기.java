import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> prefix = new HashSet<>();
		for(int n = 0; n < N; n++) {
			String input = br.readLine();
			for(int i = 1; i <= input.length(); i++)
				prefix.add(input.substring(0, i));
			
		}
		
		int ans = 0;
		for(int m = 0; m < M; m++) {
			String sentence = br.readLine();
			if(prefix.contains(sentence))
				ans++;
		}
		
		System.out.print(ans);
	}
}
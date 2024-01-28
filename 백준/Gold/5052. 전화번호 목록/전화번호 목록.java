import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static String[] list;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new String[N];

			for (int n = 0; n < N; n++) {
				list[n] = br.readLine();
			}
			
			Arrays.sort(list);
			consistency();
		}
		
		System.out.print(sb.toString());
	}

	public static void consistency() {
		for (int i = 0; i < N - 1; i++) {
			if(list[i+1].startsWith(list[i])) {
				sb.append("NO").append("\n");
				return;
			}
		}
		sb.append("YES").append("\n");
		return;
	}
}
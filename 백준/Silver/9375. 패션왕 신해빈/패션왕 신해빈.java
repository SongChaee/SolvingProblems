import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			HashMap<String, Integer> hash = new HashMap<>();

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				String name = st.nextToken();
				String type = st.nextToken();

				hash.put(type, hash.getOrDefault(type, 0) + 1);
			}

			int ans = 1;
			for (int num : hash.values())
				ans *= (num + 1);

			sb.append(ans - 1).append("\n");
		}

		System.out.print(sb.toString());

	}
}

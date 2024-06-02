import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] info = new int[N][5];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++)
				info[i][j] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			Set<Integer> s = new HashSet<>();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < N; k++) {
					if (i == k)
						continue;
					if (info[i][j] == info[k][j])
						s.add(k);
				}
			}

			if (s.size() > max) {
				max = s.size();
				idx = i;
			}
		}

		System.out.println(idx + 1);
	}
}

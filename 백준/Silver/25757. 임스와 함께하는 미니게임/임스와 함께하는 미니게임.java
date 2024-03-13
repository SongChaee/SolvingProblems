import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		String type = st.nextToken();

		int opt = 0;
		if (type.equals("Y"))
			opt = 1;
		else if (type.equals("F"))
			opt = 2;
		else
			opt = 3;

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		System.out.println(set.size() / opt);

	}
}
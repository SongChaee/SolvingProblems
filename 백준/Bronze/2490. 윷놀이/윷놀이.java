import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 0)
					cnt++;
			}

			if (cnt == 0)
				sb.append("E").append("\n");
			else if (cnt == 1)
				sb.append("A").append("\n");
			else if (cnt == 2)
				sb.append("B").append("\n");
			else if (cnt == 3)
				sb.append("C").append("\n");
			else if (cnt == 4)
				sb.append("D").append("\n");
		}

		System.out.print(sb.toString());
	}

}
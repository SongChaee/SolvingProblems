import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[] group = new boolean[21];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String order = st.nextToken();
			int num = 0;

			switch (order) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				group[num] = true;
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				group[num] = false;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(group[num])
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				group[num] = !group[num];
				break;
			case "all":
				Arrays.fill(group, true);
				break;
			case "empty":
				Arrays.fill(group, false);
				break;
			}
		}
		
		System.out.print(sb.toString());
	}
}
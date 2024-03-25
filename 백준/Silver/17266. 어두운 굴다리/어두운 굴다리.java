import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] exist = new boolean[len + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++)
			exist[Integer.parseInt(st.nextToken())] = true;

		int height = Integer.MIN_VALUE;
		int idx = 0;
		int temp = 0;

		while (idx <= len) {
			if (idx == len) {
				height = Math.max(height, len - temp);
			}

			if (exist[idx]) {
				int h = 0;
				if (exist[temp]) {
					h = ((idx - temp) % 2 == 0) ? ((idx - temp) / 2) : ((idx - temp + 1) / 2);
				} else {
					h = idx - temp;
				}

				height = Math.max(height, h);
				temp = idx;
			}

			idx++;
		}

		System.out.print(height);
	}
}

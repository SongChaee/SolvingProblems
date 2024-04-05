import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] order = br.readLine().toCharArray();

		int red = 0;
		int blue = 0;

		for (int i = 0; i < N; i++) {
			if (order[i] == 'R')
				red++;
			else
				blue++;
		}

		// 1. R을 왼쪽에 배치하는 경우
		int cnt = 0;
		int ans = N;
		for (int i = 0; i < N; i++) {
			if (order[i] == 'R')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, red - cnt);

		// 2. R을 오른쪽에 배치하는 경우
		cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (order[i] == 'R')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, red - cnt);

		// 3. B를 왼쪽에 배치하는 경우
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (order[i] == 'B')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, blue - cnt);

		// 4. B를 오른쪽에 배치하는 경우
		cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (order[i] == 'B')
				cnt++;
			else
				break;
		}
		ans = Math.min(ans, blue - cnt);

		System.out.println(ans);

	}
}

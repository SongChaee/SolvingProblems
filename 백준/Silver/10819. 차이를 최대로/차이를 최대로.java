import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static boolean[] visit;
	static int[] select;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N];
		visit = new boolean[N];
		select = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		dfs(0);

		System.out.println(result);
	}

	public static void dfs(int count) {
		if (count == N) {
			result = Math.max(getResult(), result);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[count] = num[i];

				dfs(count + 1);

				visit[i] = false;
			}
		}
	}

	public static int getResult() {
		int sum = 0;

		for (int i = 0; i < N - 1; i++)
			sum += Math.abs(select[i] - select[i + 1]);

		return sum;
	}
}

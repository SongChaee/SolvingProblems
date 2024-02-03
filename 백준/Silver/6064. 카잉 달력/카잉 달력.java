import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[] input;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			input = new int[4];
			for (int i = 0; i < 4; i++)
				input[i] = Integer.parseInt(st.nextToken());
			sb.append(cal(input)).append("\n");
		}

		System.out.print(sb.toString());
	}

	public static long cal(int[] input) {
		int mul = minMul(input[0], input[1]);

		for (int i = input[2]; i <= mul; i += input[0]) {
			if ((i - input[3]) % input[1] == 0)
				return i;
		}

		return -1;
	}

	public static int minMul(int M, int N) {
		for (int i = 1;; i++)
			if ((M * i) % N == 0)
				return M * i;
	}
}
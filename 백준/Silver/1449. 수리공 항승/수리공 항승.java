import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int ans = 0;
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		// 첫번째 테이프가 끝나는 지점
		int tape = (int) (arr[0] - 0.5 + L);
		ans++;


		for (int i = 1; i < arr.length; i++) {
			if (tape < (int) (arr[i] + 0.5)) {
				tape = (int) (arr[i] - 0.5 + L);
				ans++;
			}
		}

		System.out.println(ans);
	}

}
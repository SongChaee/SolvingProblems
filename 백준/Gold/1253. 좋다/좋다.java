import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;

			while (true) {
				// 현재 포인터가 i인 경우 포인터 이동
				if (left == i)
					left++;
				else if (right == i)
					right--;

				// left가 right보다 크거나 같은 경우 탐색 종료
				if (left >= right)
					break;

				// 현재 두 포인터가 가르키는 곳의 원소의 합에 따라
				// 포인터를 이동하거나 cnt 증가
				int sum = num[left] + num[right];
				if (sum < num[i])
					left++;
				else if (sum > num[i])
					right--;
				else {
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);

	}
}

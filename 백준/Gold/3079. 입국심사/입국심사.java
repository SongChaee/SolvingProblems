import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static long M;
	public static int[] time;
	public static long max;
	public static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		time = new int[N];
		for (int i = 0; i < N; i++)
			time[i] = Integer.parseInt(br.readLine());
		Arrays.sort(time);

		// 가장 오래 걸리는 심사대 * 사람 수 = 소요되는 최대 시간
		max = time[N - 1] * M;
		ans = max;
		
		find();
		
		System.out.println(ans);

	}

	// 이분 탐색을 활용한 최소 시간 계산
	public static void find() {
		long left = 0;
		long right = max;

		while (left <= right) {
			long mid = (left + right) / 2;

			// 현재 시간에 심사대를 거친 사람의 합
			long sum = 0;

			for (int i : time) {
				long cnt = mid / i;

				// 종료 조건
				// 1. 현재 심사를 완료한 사람이 총 사람 수보다 많은 경우
				// 2. 현재 심사대의 소요 시간 i가 mid보다 큰 경우
				if (sum >= M || i > mid)
					break;

				sum += cnt;
			}

			// 종료조건 1 : 시간 단축 가능
			if (sum >= M) {
				right = mid - 1;
				ans = Math.min(ans, mid);
			}
			// 종료조건 2 : 더 많은 시간 필요
			else
				left = mid + 1;
		}
	}
}

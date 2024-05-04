import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] result;
	public static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		result = new int[N][9];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++)
				result[i][j] = Integer.parseInt(st.nextToken());
		}

		int[] order = new int[9];
		boolean[] used = new boolean[9];
		used[0] = true;

		setOrder(0, order, used);

		System.out.println(ans);
	}

	public static void setOrder(int idx, int[] order, boolean[] used) {
		// 9명 선수의 타순 결정 완료된 경우
		if (idx >= 9) {
			calculate(order);
			return;
		}

		// 현재 idx 번째 타자를 선택하는 경우
		for (int i = 0; i < 9; i++) {
			if (!used[i]) {
				order[idx] = i;
				used[i] = true;
				if (idx == 2)
					setOrder(idx + 2, order, used);
				else
					setOrder(idx + 1, order, used);
				used[i] = false;
			}
		}

	}

	public static void calculate(int[] order) {
		int idx = 0; // 현재 타자 번호
		int round = 0; // 현재 이닝 수
		int out = 0; // 현재 아웃 수
		int score = 0; // 현재 점수

		while (round < N) {
			int[] bases = new int[4];
			out = 0;

			while (out < 3) {
				int hitter = order[idx];
				int hitresult = result[round][hitter];

				// 아웃
				if (hitresult == 0)
					out++;
				// 안타 혹은 홈런
				else {
					// 베이스에 진출한 선수들 먼저 이동
					for (int i = 3; i >= 1; i--) {
						// 현재 베이스에 주자가 있을 경우
						if (bases[i] == 1) {
							if (i + hitresult >= 4) {
								score++;
							} else {
								bases[i + hitresult] = 1;
							}
							bases[i] = 0;
						}
					}
					// 현재 타자 이동
					if (hitresult < 4) {
						bases[hitresult] = 1;
					} else {
						// 득점 증가 (홈런 + 3루 주자)
						score += 1 + bases[3];
						bases[3] = 0;
					}
				}

				// 다음 타자로 이동
				idx = (idx + 1) % 9;

				// 이닝 종료 조건
				if (out >= 3)
					round++;
			}
		}

		ans = Math.max(ans, score);
	}
}

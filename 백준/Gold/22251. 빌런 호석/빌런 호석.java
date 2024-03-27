import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int maxFloor;
	public static int place;
	public static int P;
	public static int nowFloor;

	public static int[][] digit = { { 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 1, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1 }, };
	public static int[][] reverse = new int[10][10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		maxFloor = Integer.parseInt(st.nextToken());
		place = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		nowFloor = Integer.parseInt(st.nextToken());

		// 숫자 i에서 j로 바꿀 때 반전되는 led의 개수 미리 계산
		difference();

		int ans = 0;
		String real = display(nowFloor);
		for (int floor = 1; floor <= maxFloor; floor++) {
			if (floor == nowFloor)
				continue;

			String fake = display(floor);

			int cnt = 0;
			for (int i = 0; i < place; i++) {
				if (real.charAt(i) == fake.charAt(i))
					continue;
				else {
					cnt += reverse[real.charAt(i) - '0'][fake.charAt(i) - '0'];
				}
			}

			if (cnt <= P)
				ans++;
		}

		System.out.print(ans);
	}

	public static String display(int floor) {
		String tmp = Integer.toString(floor);

		if (tmp.length() == place)
			return tmp;
		else {
			while (tmp.length() != place) {
				tmp = "0" + tmp;
			}
			return tmp;
		}
	}

	public static void difference() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j)
					continue;
				if (reverse[i][j] != 0)
					continue;
				int cnt = 0;
				for (int k = 0; k < 7; k++) {
					if (digit[i][k] != digit[j][k])
						cnt++;
				}
				reverse[i][j] = cnt;
				reverse[j][i] = cnt;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static String[] list = { "1", "2", "3" };
	static String answer = "9";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dfs(0, "");

		System.out.println(answer);
	}

	public static void dfs(int index, String origin) {
		if (index == n) {
			System.out.println(origin);
			System.exit(0);
		}

		for (int i = 0; i <= 2; i++) {
			if (check(origin + list[i])) {
				dfs(index + 1, origin + list[i]);
			}
		}
	}

	public static boolean check(String checkStr) {
		int length = checkStr.length() / 2;

		for (int i = 1; i <= length; i++) {
			String substr1 = checkStr.substring(checkStr.length() - i);
			String substr2 = checkStr.substring(checkStr.length() - 2 * i, checkStr.length() - i);

			if (substr1.equals(substr2))
				return false;
		}

		return true;
	}
}
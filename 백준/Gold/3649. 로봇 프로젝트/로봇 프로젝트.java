import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		while ((input = br.readLine()) != null) {
			int target = Integer.parseInt(input) * 10000000;
			int N = Integer.parseInt(br.readLine());

			int[] pieces = new int[N];
			for (int i = 0; i < N; i++)
				pieces[i] = Integer.parseInt(br.readLine());

			Arrays.sort(pieces);

			int left = 0;
			int right = N - 1;
			boolean flag = false;

			while (left < right) {
				int sum = pieces[left] + pieces[right];

				if (sum == target) {
					System.out.println("yes " + pieces[left] + " " + pieces[right]);
					flag = true;
					break;
				} else if (sum > target)
					right--;
				else
					left++;
			}

			if (!flag)
				System.out.println("danger");
		}
	}
}

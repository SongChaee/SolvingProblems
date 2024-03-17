import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int[] array = { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
					Integer.parseInt(token.nextToken()) };

			if (array[0] == 0 && array[1] == 0 && array[2] == 0) {
				break;
			}

			if ((array[0] >= array[1] + array[2]) || (array[1] >= array[0] + array[2])
					|| (array[2] >= array[0] + array[1])) {
				System.out.println("Invalid");
			} else if (array[0] == array[1] && array[1] == array[2]) {
				System.out.println("Equilateral");
			} else if ((array[0] == array[1]) || (array[0] == array[2]) || (array[1] == array[2])) {
				System.out.println("Isosceles");
			} else if ((array[0] != array[1]) && (array[1] != array[2]) && (array[2] != array[0])) {
				System.out.println("Scalene");
			}
		}
	}
}
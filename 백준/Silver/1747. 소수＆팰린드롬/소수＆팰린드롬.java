import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		if (num == 1) {
			System.out.print("2");
			return;
		} else {
			while(true) {
				if(isPrime(num) && isPalin(Integer.toString(num))) {
					System.out.print(num);
					return;
				}
				num++;
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public static boolean isPalin(String n) {
		for (int i = 0; i < n.length() / 2; i++)
			if (n.charAt(i) != n.charAt(n.length() - 1 - i))
				return false;
		return true;
	}
}
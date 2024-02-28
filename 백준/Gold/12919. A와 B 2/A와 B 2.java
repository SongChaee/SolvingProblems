import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String str1, str2;
	static int len1;
	static boolean flag = false;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();

		len1 = str1.length();

		recur(str2);
		
		System.out.print(flag ? 1 : 0);
	}

	public static void recur(String str) {
		if(str.length() == len1) {
			if(str.equals(str1))
				flag = true;
			return;
		}
		
		if(str.charAt(str.length() - 1) == 'A')
			recur(str.substring(0, str.length() - 1));
		
		if(str.charAt(0) == 'B') {
			sb = new StringBuilder();
			sb.append(str.substring(1, str.length()));
			recur(sb.reverse().toString());
		}
	}
}
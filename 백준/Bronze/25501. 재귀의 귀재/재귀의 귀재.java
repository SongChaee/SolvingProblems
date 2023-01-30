import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String s = br.readLine();
			cnt = 0;
			bw.write(isPalindrome(s) + " " + cnt + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
	
	public static int recursion(String s, int l, int r) {
		if(l >= r) {
			cnt++;
			return 1;
		}
		else if(s.charAt(l) != s.charAt(r)) {
			cnt++;
			return 0;
		}
		else{
			cnt++;
			return recursion(s, l + 1, r - 1);
		}
	}
}

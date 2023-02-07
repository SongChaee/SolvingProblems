import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		int[] arr = new int['z' - 'a' + 1];
		
		for(int i = 0; i < s.length(); i++) {
			for(int c = 'a'; c <= 'z'; c++) {
				if(s.charAt(i) == c) {
					arr[c-'a'] += 1;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			bw.write(arr[i] + " ");
		
		bw.flush();
		br.close();
		bw.close();
	}
}

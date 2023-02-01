import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s;
        
		while((s = br.readLine()) != null) {
			int N = Integer.parseInt(s);
			int num = (int) Math.pow(3, N);
			sb = new StringBuilder();
			for(int i = 0; i < num; i++)
				sb.append("-");
			blank(0, num);
			bw.write(sb + "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static void blank(int start, int length) { 
		if(length < 3) return;
		for(int i = start + length / 3; i < start + length / 3 * 2; i++)
			sb.setCharAt(i, ' ');
		blank(start, length / 3);
		blank(start + length / 3 * 2, length / 3);
	}
}

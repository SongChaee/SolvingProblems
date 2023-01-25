import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		String[][] user = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			user[i][0] = st.nextToken();
			user[i][1] = st.nextToken();
		}
		br.close();
		
		Arrays.sort(user, (o1, o2) -> {
			return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
		});
		
		for(int i = 0; i < N; i++) {
			bw.write(user[i][0] + " " + user[i][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}

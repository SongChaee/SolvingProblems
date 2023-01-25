import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[][] grade = new String[N][4];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++)
				grade[i][j] = st.nextToken();
		}
		br.close();
		
		Arrays.sort(grade, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
					if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
						if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3]))
							return o1[0].toString().compareTo(o2[0].toString());
						return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
					}
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				}else
					return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			}
		});
		
		for(int i = 0; i < N; i++)
			bw.write(grade[i][0] + "\n");
		bw.flush();
		bw.close();
	}
}

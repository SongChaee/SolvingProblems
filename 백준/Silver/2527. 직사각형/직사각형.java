import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] R1, R2;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			R1 = new int[2][2];
			R2 = new int[2][2];
			
			for(int j = 0; j < 2; j++) {
				R1[j][0] = Integer.parseInt(st.nextToken());
				R1[j][1] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 2; j++) {
				R2[j][0] = Integer.parseInt(st.nextToken());
				R2[j][1] = Integer.parseInt(st.nextToken());
			}
			
			if(R1[0][0] <= R2[0][0])
				determin(R1, R2);
			else
				determin(R2, R1);
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void determin(int[][] a1, int[][] a2) {
		if(a1[0][0] == a2[0][0]) {
			if(a2[0][1] == a1[0][1])
				sb.append("a");
			else if(a2[0][1] < a1[0][1]) {
				if(a2[1][1] < a1[0][1])
					sb.append("d");
				else if(a2[1][1] == a1[0][1])
					sb.append("b");
				else if(a2[1][1] > a1[0][1])
					sb.append("a");
			}
			else if(a2[0][1] > a1[0][1]) {
				if(a2[0][1] > a1[1][1])
					sb.append("d");
				else if(a2[0][1] == a1[1][1])
					sb.append("b");
				else if(a2[0][1] < a1[1][1])
					sb.append("a");
			}
		}
		else if(a1[1][0] > a2[0][0]) {
			if(a1[0][1] == a2[0][1])
				sb.append("a");
			else if(a1[0][1] > a2[0][1]) {
				if(a2[1][1] < a1[0][1])
					sb.append("d");
				else if(a2[1][1] == a1[0][1])
					sb.append("b");
				else if(a2[1][1] > a1[0][1])
					sb.append("a");
			}
			else if(a1[0][1] < a2[0][1]) {
				if(a1[1][1] < a2[0][1])
					sb.append("d");
				else if(a1[1][1] == a2[0][1])
					sb.append("b");
				else if(a1[1][1] > a2[0][1])
					sb.append("a");
			}
		}
		else if(a1[1][0] < a2[0][0]) {
			sb.append("d");
		}
		else if(a1[1][0] == a2[0][0]) {
			if(a2[0][1] < a1[0][1]) {
				if(a2[1][1] < a1[0][1])
					sb.append("d");
				else if(a2[1][1] == a1[0][1])
					sb.append("c");
				else if(a2[1][1] > a1[0][1])
					sb.append("b");
			}
			else if(a2[0][1] == a1[0][1])
				sb.append("b");
			else if(a2[0][1] > a1[0][1]) {
				if(a2[0][1] == a1[1][1])
					sb.append("c");
				else if(a2[0][1] > a1[1][1])
					sb.append("d");
				else if(a2[0][1] < a1[1][1])
					sb.append("b");
			}
		}
	}
}
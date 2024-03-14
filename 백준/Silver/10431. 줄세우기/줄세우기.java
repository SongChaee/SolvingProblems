import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc <= N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int t = Integer.parseInt(st.nextToken());
			sb.append(t).append(" ");
			
			int[] arr = new int[20];
			int cnt = 0;
			for(int i = 0; i < 20; i++) {
				int height = Integer.parseInt(st.nextToken());
				arr[i] = height;
				if(i > 0) {
					for(int j = i - 1; j >= 0; j--) {
						if(arr[j] > arr[i])
							cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		boolean findHead = false;
		boolean findArm = false;
		int headx = Integer.MAX_VALUE;
		int heady = Integer.MAX_VALUE;
		int heartx = Integer.MAX_VALUE;
		int hearty = Integer.MAX_VALUE;
		int army = 0;
		int armcnt = 0;
		int waistx = Integer.MAX_VALUE;
		int waisty = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '*' && !findHead) {
					headx = i;
					heady = j;
					heartx = i + 1;
					hearty = j;
					findHead = true;
				}
				if (i == heartx && map[i][j] == '*' && !findArm) {
					army = j;
					findArm = true;
				}
				if (i == heartx && map[i][j] == '*') {
					armcnt++;
				}
				if (i == heartx + 1 && map[i][j] == '*') {
					waistx = i;
					waisty = j;
				}
			}
		}
		
		// 심장의 좌표
		sb.append(heartx + 1).append(" ").append(hearty + 1).append("\n");

		// 팔 길이
		sb.append(hearty - army).append(" ").append(armcnt - (hearty - army) - 1).append(" ");
		
		// 허리 길이
		int cnt = 0;
		for(int i = 0; i < N; i++)
			if(map[i][waisty] == '*')
				cnt++;
		sb.append(cnt - 2).append(" ");
		
		// 다리 길이
		cnt = 0;
		for(int i = 0; i < N; i++)
			if(map[i][waisty - 1] == '*')
				cnt++;
		sb.append(cnt - 1).append(" ");
		
		cnt = 0;
		for(int i = 0; i < N; i++)
			if(map[i][waisty + 1] == '*')
				cnt++;
		sb.append(cnt - 1);
		
		System.out.print(sb.toString());
	}
}
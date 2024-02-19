import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] vote;
	static boolean[] visit, done;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			vote = new int[N + 1];
			visit = new boolean[N + 1];
			done = new boolean[N + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				vote[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			for(int n = 1; n <= N; n++)
				dfs(n);
			
			sb.append(N - cnt).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void dfs(int idx) {
		// 판별이 끝난 사람
		if(done[idx]) return;
		
		// 방문한 적이 있는 사람
		if(visit[idx]) {
			done[idx] = true;
			cnt++;
		}
		
		// 판별x, 방문x -> 처음 방문한 사람
		// 해당 사람이 투표한 학생으로 dfs 수행
		visit[idx] = true;
		dfs(vote[idx]);
		
		// 판별이 끝났음을 표시하고 방문 체크 초기화
		done[idx] = true;
		visit[idx] = false;
	}
}
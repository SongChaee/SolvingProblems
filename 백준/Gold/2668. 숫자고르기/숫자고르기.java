import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visit, done, made;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		visit = new boolean[N + 1];
		done = new boolean[N + 1];
		made = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++)
			dfs(i);
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(made[i])
				cnt++;
		}
		sb.append(cnt).append("\n");
		
		for(int i = 1; i <= N; i++) {
			if(made[i])
				sb.append(i).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static void dfs(int idx) {
		// 이미 집합이 된 수인 경우
		if(done[idx])
			return;
		
		// dfs를 수행하면서 방문했던 수인 경우
		if(visit[idx]) {
			done[idx] = true;
			made[idx] = true;
		}
		
		// 처음 방문한 수인 경우
		visit[idx] = true;
		dfs(arr[idx]);
		
		// 판별이 끝난 후
		done[idx] = true;
		visit[idx] = false;
	}
}
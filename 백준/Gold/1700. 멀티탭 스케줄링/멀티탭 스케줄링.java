import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static int[] order;
	public static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 사용하는 전기제품 순서
		order = new int[K];
		// 현재 콘센트에 꽂혀있는 전기제품
		int[] now = new int[N];
		int idx = 0;
		// 해당 전기제품이 사용중인지 판별
		boolean[] used = new boolean[101];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			if (idx < N) {
				if (used[order[i]])
					continue;
				now[idx++] = order[i];
				used[order[i]] = true;
			}
		}
		
		plug(N, now, used, 0);
		
		System.out.println(ans);

	}

	public static void plug(int idx, int[] now, boolean[] used, int cnt) {
		if (idx >= K) {
			ans = Math.min(ans, cnt);
			return;
		}

		// 이번에 사용하려는 전기제품이 이미 플러그에 꽂혀 있는 경우
		if (used[order[idx]])
			plug(idx + 1, now, used, cnt);
		
		// 플러그에 있는 제품을 뽑아 새로 꽂아야하는 경우
		else if(!used[order[idx]]) {
			// 현재 꽂혀 있는 제품이 이후에 또 사용되는지 판단
			int[] after = new int[N];
			for(int i = idx + 1; i < K; i++) {
				for(int j = 0; j < N; j++) {
					if(now[j] == order[i] && after[j] == 0)
						after[j] = i;
				}
			}
			
			int target = -1;
			int max = after[0];
			int maxidx = 0;
			for(int i = 0; i < N; i++) {
				if(after[i] == 0 && target == -1) {
					target = i;
				}
				if(max < after[i]) {
					max = after[i];
					maxidx = i;
				}
			}
			
			target = target == -1 ? maxidx : target;
			
			used[now[target]] = false;
			now[target] = order[idx];
			used[order[idx]] = true;
			plug(idx + 1, now, used, cnt + 1);
		}
	}
}

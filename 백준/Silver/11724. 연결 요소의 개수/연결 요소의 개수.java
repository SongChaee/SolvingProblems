import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		// 정점의 개수 V, 간선의 개수 E 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 간선 정보 입력
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= V; i++)
			graph.add(new ArrayList<>());
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 연결 요소 개수 계산
		int ans = 0;
		boolean[] visit = new boolean[V + 1];
		Queue<Integer> q;
		for(int i = 1; i <= V; i++) {
			q = new LinkedList<>();
			
			// 이미 연결된 노드에 대해서는 continue
			if(visit[i])
				continue;
			
			// 연결되지 않은 노드에 대해서만 수행
			q.add(i);
			visit[i] = true;
			ans++;
			while(!q.isEmpty()) {
				int check = q.poll();
				for(int next : graph.get(check)) {
					if(visit[next])
						continue;
					q.add(next);
					visit[next] = true;
				}
			}
		}
		
		// 결과 출력
		System.out.print(ans);
	}
}
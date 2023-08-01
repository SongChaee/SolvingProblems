import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 역의 개수 N
		int N = Integer.parseInt(st.nextToken());
		
		// 하나의 하이퍼튜브가 연결하는 역의 개수 K
		int K = Integer.parseInt(st.nextToken());
		
		// 하이퍼튜브의 개수 M
		int M = Integer.parseInt(st.nextToken());
		
		// 인접리스트를 활용한 그래프 탐색
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		// 1~N번 : 역의 번호, N+1~N+M : 하이퍼튜브의 번호
		for(int i = 0; i <= N + M; i++)
			graph.add(new ArrayList<>());
		
		// 하이퍼튜브, 역의 정보 입력
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int k = 0; k < K; k++) {
				int station = Integer.parseInt(st.nextToken());
				// 하이퍼튜브>역 연결
				graph.get(N+1+m).add(station);
				// 역>하이퍼튜브 연결
				graph.get(station).add(N+1+m);
			}
		}
		
		// i번째 역까지 거치는 노드의 개수
		int[] dist = new int[N+M+1];
		// 해당 노드를 방문했는지 여부 판별
		boolean[] visit = new boolean[N+M+1];
		
		// N번 역에 도달할 수 있는지 bfs 수행
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		dist[1] = 0;
		while(!q.isEmpty()) {
			int check = q.poll();
			for(int i = 0; i < graph.get(check).size(); i++) {
				int next = graph.get(check).get(i);
				if(visit[next]) continue;
				q.add(next);
				visit[next] = true;
				dist[next] = dist[check] + 1;
			}
		}
		
		System.out.print(visit[N] ? dist[N]/2+1 : -1);
	}
}
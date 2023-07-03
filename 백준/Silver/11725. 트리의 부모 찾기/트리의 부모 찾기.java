import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// 노드 개수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 간선 정보 입력
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			tree.add(new ArrayList<>());
		StringTokenizer st;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		// 부모 노드 탐색
		int[] parent = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int check = q.poll();
			for(int i = 0; i < tree.get(check).size(); i++) {
				int next = tree.get(check).get(i);
				if(visit[next])
					continue;
				parent[next] = check;
				q.add(next);
				visit[next] = true;
			}
		}
		
		// 결과 출력
		for(int i = 2; i <= N; i++)
			sb.append(parent[i] + "\n");
		System.out.print(sb.toString());
	}
}

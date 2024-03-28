import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, V;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		for(int i = 1; i <= N; i++)
			Collections.sort(graph.get(i));
		
		visit = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		
		visit = new boolean[N + 1];
		bfs();
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int start) {
		visit[start] = true;
		sb.append(start).append(" ");
		
		for(int next : graph.get(start)) {
			if(visit[next])
				continue;
			dfs(next);
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		visit[V] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			
			for(int next : graph.get(now)) {
				if(visit[next])
					continue;
				q.add(next);
				visit[next] = true;
			}
		}
	}
}
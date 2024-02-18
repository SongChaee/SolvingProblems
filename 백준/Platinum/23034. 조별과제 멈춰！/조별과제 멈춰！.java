import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int from;
	int to;
	int weight;
	
	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}

class SelectedNode{
	int to;
	int weight;
	
	public SelectedNode(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	static int V;
	static int[] p;
	static ArrayList<Node> graph;
	static int[] leader = new int[2];
	static ArrayList<ArrayList<SelectedNode>> selected;
	static int[][] dist;
	static boolean[] visit;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		// 간선 정보 입력
		graph = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.add(new Node(from, to, weight));
		}
		Collections.sort(graph);
		
		selected = new ArrayList<>();
		for(int i = 0; i <= V; i++)
			selected.add(new ArrayList<>());
		
		// 최소 신장 트리 계산
		long mst = kruskal();
		
		
		// 팀장1 - 팀장2 노드 간 최대 거리 계산
		dist = new int[V + 1][V + 1];
		for(int i = 0; i <= V; i++)
			Arrays.fill(dist[i], -1);
		for(int i = 1; i <= V; i++)
			bfs(i);
		

		// Q개의 질문에 대한 bfs 계산
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(mst - dist[a][b]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static void bfs(int idx) {
		visit = new boolean[V + 1];
		dist[idx][idx] = 0;
		visit[idx] = true;
		
		q = new LinkedList<>();
		q.add(idx);
		
		while(!q.isEmpty()) {
			int check = q.poll();
			for(SelectedNode n : selected.get(check)) {
				int to = n.to;
				int weight = n.weight;
				
				if(visit[to]) continue;
				
				dist[idx][to] = Math.max(Math.max(dist[idx][to], dist[idx][check]), weight);
				visit[to] = true;
				q.add(to);
			}
		}
	}
	
	public static long kruskal() {
		makeP();
		long sum = 0;
		
		for(Node n : graph) {
			int from = n.from;
			int to = n.to;
			int weight = n.weight;
			
			if(find(from) == find(to))
				continue;
			
			selected.get(from).add(new SelectedNode(to, weight));
			selected.get(to).add(new SelectedNode(from, weight));
			
			sum += (long) weight;
			union(from, to);
		}
		
		return sum;
	}
	
	public static int find(int x) {
		if(x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px != py) {
			if(py == leader[0] || py == leader[1])
				p[px] = py;
			else
				p[py] = px;
		}
	}
	
	public static void makeP() {
		p = new int[V + 1];
		for(int i = 0; i <= V; i++)
			p[i] = i;
	}
}
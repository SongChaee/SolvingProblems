import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Node {
	int idx;
	int x;
	int y;
	int z;

	public Node(int idx, int x, int y, int z) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge e) {
		return weight - e.weight;
	}
}

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[V];
		StringTokenizer st;
		for(int v = 0; v < V; v++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			node[v] = new Node(v, x, y, z);
		}
		
		p = new int[V];
		for(int v = 0; v < V; v++)
			p[v] = v;
		
		ArrayList<Edge> graph = new ArrayList<>();
		
		Arrays.sort(node, (n1, n2) -> n1.x - n2.x);
		for(int i = 0; i < V - 1; i++) {
			int cost = Math.abs(node[i].x - node[i + 1].x);
			graph.add(new Edge(node[i].idx, node[i + 1].idx, cost));
		}
		
		Arrays.sort(node, (n1, n2) -> n1.y - n2.y);
		for(int i = 0; i < V - 1; i++) {
			int cost = Math.abs(node[i].y - node[i + 1].y);
			graph.add(new Edge(node[i].idx, node[i + 1].idx, cost));
		}
		
		Arrays.sort(node, (n1, n2) -> n1.z - n2.z);
		for(int i = 0; i < V - 1; i++) {
			int cost = Math.abs(node[i].z - node[i + 1].z);
			graph.add(new Edge(node[i].idx, node[i + 1].idx, cost));
		}
		
		Collections.sort(graph);
		
		long ans = 0;
		int v = 0;
		for(Edge e : graph) {
			if(v == V - 1) break;
			
			int from = e.from;
			int to = e.to;
			int weight = e.weight;
			
			if(find(from) == find(to))
				continue;
			
			ans += (long) weight;
			union(from, to);
			v++;
		}
		
		System.out.print(ans);
	}
	
	public static int find(int x) {
		if(x != p[x])
			p[x] = find(p[x]);
		return p[x];
	}
	
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px != py)
			p[py] = px;
	}
}
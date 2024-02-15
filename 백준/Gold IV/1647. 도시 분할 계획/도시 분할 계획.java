import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
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

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node> graph = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.add(new Node(from, to, weight));
		}
		Collections.sort(graph);
		
		p = new int[V + 1];
		for(int v = 0; v <= V; v++)
			p[v] = v;
		
		int sum = 0;
		int maxWeight = 0;
		for(Node n : graph) {
			int from = n.from;
			int to = n.to;
			int weight = n.weight;
			
			if(find(from) == find(to))
				continue;
			
			sum += weight;
			union(from, to);
			maxWeight = weight;
		}
		
		System.out.print(sum - maxWeight);
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

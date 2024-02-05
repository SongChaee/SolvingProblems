import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int next;
	int cost;
	
	public Node(int next, int cost) {
		this.next = next;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node n) {
		return cost - n.cost;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		for(int n = 0; n <= N; n++)
			graph.add(new ArrayList<>());
		
		StringTokenizer st;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, cost));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int depart = Integer.parseInt(st.nextToken());
		int arrive = Integer.parseInt(st.nextToken());

		System.out.print(dijkstra(depart, arrive));
		
	}
	
	static int dijkstra(int depart, int arrive) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		boolean[] visit = new boolean[N + 1];
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(depart, 0));
		dist[depart] = 0;
		
		while(!q.isEmpty()) {
			Node check = q.poll();
			
			if(!visit[check.next]) {
				visit[check.next] = true;
				
				for(Node next : graph.get(check.next)) {
					if(visit[next.next]) continue;
					if(dist[next.next] <= dist[check.next] + next.cost) continue;
					dist[next.next] = dist[check.next] + next.cost;
					q.add(new Node(next.next, dist[next.next]));
				}
			}
		}
		
		return dist[arrive];
	}
}
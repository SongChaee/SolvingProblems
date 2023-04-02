import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static double[][] loca;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			
			loca = new double[V][2];
			for(int i = 0; i < V; i++)
				loca[i][0] = sc.nextDouble();
			for(int i = 0; i < V; i++)
				loca[i][1] = sc.nextDouble();
			
			double tax = sc.nextDouble();
			
			List<Edge>[] adjList = new ArrayList[V];
			
			for(int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			
			for(int i = 0; i < V; i++) {
				for(int j = i + 1; j < V; j++) {
					double price = tax * (double) (Math.pow(loca[j][0] - loca[i][0], 2) + Math.pow(loca[j][1] - loca[i][1], 2));
					adjList[i].add(new Edge(i, j, price));
					adjList[j].add(new Edge(j, i, price));
				}
			}
			
			boolean[] visited = new boolean[V];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			//visited[0] = true;
			pq.addAll(adjList[0]);
			
			double sum = 0;
			int pick = 0;
			
			while(pick != V) {
				Edge e = pq.poll();
				
				if(visited[e.ed]) continue;
				
				if(pick != 0)
					sum += e.w;
				pq.addAll(adjList[e.ed]);
				visited[e.ed] = true;
				pick++;
			}
			
			System.out.println("#" + tc + " " + Math.round(sum));
		}
	}
	
	
	static class Edge implements Comparable<Edge>{
		int st, ed;
		double w;
		
		public Edge(int st, int ed, double w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
}

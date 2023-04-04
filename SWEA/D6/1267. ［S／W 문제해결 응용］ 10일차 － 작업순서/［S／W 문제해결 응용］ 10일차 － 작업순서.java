import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i = 0; i <= V; i++)
				graph.add(new ArrayList<Integer>());
			
			int[] degree = new int[V + 1];
			
			for(int i = 0; i < E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				graph.get(st).add(ed);
				degree[ed]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= V; i++)
				if(degree[i] == 0)
					q.add(i);
			
			while(!q.isEmpty()) {
				int check = q.poll();
				sb.append(check).append(" ");
				
				for(int i = 0; i < graph.get(check).size(); i++) {
					if(--degree[graph.get(check).get(i)] == 0)
						q.add(graph.get(check).get(i));
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
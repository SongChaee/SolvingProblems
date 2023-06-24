import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int V;
	// 노드 별 연결된 노드와 가중치를 담는 리스트
	public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	// 최단 거리를 담는 배열
	public static int[] w;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 정점 수, 간선 수 입력
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		// 시작 정점 번호 입력
		int startV = Integer.parseInt(br.readLine());
		
		// 관련 변수 초기화
		for(int i = 0; i <= V; i++)
			list.add(new ArrayList<Node>());
		w = new int[V+1];
		Arrays.fill(w, Integer.MAX_VALUE);
		
		// 간선 정보 입력
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sta = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(sta).add(new Node(end, weight));
		}
		
		// 시작점으로부터 최단 경로 탐색
		shortest(startV);
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(w[i] != Integer.MAX_VALUE)
				sb.append(w[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void shortest(int st) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(st, 0));
		boolean[] visit = new boolean[V + 1];
		// 현재 시작점인 st의 자기자신 가중치는 0으로 설정
		w[st] = 0;
		
		while(!q.isEmpty()) {
			Node check = q.poll();
			
			// 다음 노드가 이미 탐색했던 노드라면 건너뛰고
			// 탐색하지 않았던 노드라면 방문 처리
			if(visit[check.end])
				continue;
			visit[check.end] = true;
			
			// 현재 탐색 노드에서 다음 노드로의 가중치가
			// 현재 저장된 가중치 값보다 작을 때만 값을 갱신하고 큐에 삽입
			for(int i = 0; i < list.get(check.end).size(); i++) {
				Node next = list.get(check.end).get(i);
				if(w[next.end] > w[check.end] + next.weight) {
					w[next.end] = w[check.end] + next.weight;
					q.add(new Node(next.end, w[next.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int end, weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// 학생 수 N, 키를 비교한 횟수 M 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 진입차수를 담는 배열
		int[] indegree = new int[N+1];
		
		// 그래프 구조를 담는 리스트
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());
		
		// 키를 비교한 정보 입력
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		// 위상 정렬을 위한 큐와 방문 여부 배열 선언
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		
		// 진입 차수가 0인 노드 큐에 삽입
		for(int i = 1; i <= N; i++)
			if(indegree[i] == 0)
				q.add(i);
		
		// 위상정렬 시작
		while(!q.isEmpty()) {
			int check = q.poll();
			visit[check] = true;
			sb.append(check + " ");
			
			for(int i = 0; i < graph.get(check).size(); i++) {
				int next = graph.get(check).get(i);
				// 진입차수 1 감소
				indegree[next]--;
				
				// 진입차수가 0이고 방문한 적 없는 노드인 경우
				// 큐에 삽입
				if(indegree[next] == 0 && !visit[next])
					q.add(next);
			}
		}
		
		// 결과 출력
		System.out.print(sb.toString());
	}
}
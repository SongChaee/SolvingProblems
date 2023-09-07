import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터 수
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println("0");
            return;
        }
        // 컴퓨터 연결 쌍의 수
        int M = Integer.parseInt(br.readLine());

        // 인접 리스트를 활용한 그래프 표현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        // 쌍 정보 입력
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 1번 컴퓨터와 연결되 컴퓨터 수 계산
        boolean[] visit = new boolean[N+1];
        visit[1] = true;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.get(1).size(); i++){
            if(visit[graph.get(1).get(i)]) continue;
            q.add(graph.get(1).get(i));
            visit[graph.get(1).get(i)] = true;
            while(!q.isEmpty()){
                int next = q.poll();
                count++;
                for(int j = 0; j < graph.get(next).size(); j++){
                    if(visit[graph.get(next).get(j)]) continue;
                    q.add(graph.get(next).get(j));
                    visit[graph.get(next).get(j)] = true;
                }
            }
        }

        System.out.print(count);
    }
}
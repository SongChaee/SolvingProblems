import java.util.*;

class Solution {
    public static int V;
    public static int[] dist;
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        // 최단 간선 수와 리스트 초기화
        V = n;
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= V; i++)
            list.add(new ArrayList<Node>());
        
        for(int i = 0; i < edge.length; i++){
            int st = edge[i][0];
            int ed = edge[i][1];
            list.get(st).add(new Node(ed, 1));
            list.get(ed).add(new Node(st, 1));
        }
        
        cntE(1);
        
        int max = 0;
        for(int i = 1; i <= V; i++){
            if(dist[i] != Integer.MAX_VALUE)
                max = Math.max(dist[i], max);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= V; i++)
            if(dist[i] == max)
                q.add(i);
        
        int answer = q.size();
        return answer;
    }
    
    public static void cntE(int st){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(st, 0));
        boolean[] visit = new boolean[V + 1];
        dist[st] = 0;
        
        while(!q.isEmpty()){
            Node check = q.poll();
            int cur = check.end;
            
            if(visit[cur])
                continue;
            visit[cur] = true;
            
            for(Node n : list.get(cur)){
                if(dist[n.end] > dist[cur] + n.weight){
                    dist[n.end] = dist[cur] + n.weight;
                    q.add(new Node(n.end, dist[n.end]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int end;
    int weight;
    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node n){
        return weight - n.weight;
    }
}
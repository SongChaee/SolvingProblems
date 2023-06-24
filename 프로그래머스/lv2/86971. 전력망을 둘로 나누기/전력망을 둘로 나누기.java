import java.util.*;
class Solution {
    public static int V;
    public static int[][] arr;
    public static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        V = n;
        arr = new int[V+1][V+1];
        int E = wires.length;
        for(int i = 0; i < E; i++){
            int st = wires[i][0];
            int ed = wires[i][1];
            arr[st][ed] = 1;
            arr[ed][st] = 1;
        }
        
        // 완전 탐색
        for(int i = 0; i < E; i++){
            int st = wires[i][0];
            int ed = wires[i][1];
            
            arr[st][ed] = 0;
            arr[ed][st] = 0;
            
            cut(st);
            
            arr[st][ed] = 1;
            arr[ed][st] = 1;
        }
        
        return min;
    }
    
    public static void cut(int st){
        boolean[] visit = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visit[st] = true;
        int cnt = 1;
        
        while(!q.isEmpty()){
            int check = q.poll();
            
            for(int i = 1; i <= V; i++){
                if(visit[i]) continue;
                if(arr[check][i] == 1){
                    q.add(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        
        int abs = (int)Math.abs(V - cnt * 2);
        min = Math.min(min, abs);
    }
}
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new LinkedList<>();
        
        // 현재 다리에 있는 트럭의 무게 합
        int sumWeight = 0;
        // 현재 다리에 있는 트럭의 개수
        int sumTruck = 0;
        // 경과 시간
        int time = 0;
        // 다음 오를 트럭의 index
        int idx = 0;
        
        while(true){
            // 다리를 지난 트럭 처리
            while(!q.isEmpty() && q.peek()[1] <= time){
                int[] out = q.poll();
                sumWeight -= truck_weights[out[0]];
                sumTruck--;
            }
            
            // 다음 트럭이 다리에 올라올 수 있는지 확인
            if(idx < truck_weights.length && sumWeight + truck_weights[idx] <= weight && sumTruck + 1 <= bridge_length){
                q.add(new int[] {idx, time + bridge_length});
                sumWeight += truck_weights[idx];
                sumTruck++;
                idx++;
            }
            
            time++;
            
            if(q.isEmpty() && idx >= truck_weights.length)
                break;
        }
        
        return time;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Car[] list = new Car[routes.length];
        for(int i = 0; i < routes.length; i++)
            list[i] = new Car(routes[i][0], routes[i][1]);
        
        Arrays.sort(list);
        
        int idx = 0;
        int cnt = 0;
        int camera = Integer.MIN_VALUE; // 카메라 설치 지점
        
        while(idx < list.length){
            int in = list[idx].in;
            int out = list[idx].out;
            
            // 카메라가 차량 범위를 벗어나는 경우
            if(camera < in){
                camera = out;
                cnt++;
            }
            
            idx++;
        }
        
        return cnt;
    }
}

class Car implements Comparable<Car>{
    int in;
    int out;
    
    public Car(int in, int out){
        this.in = in;
        this.out = out;
    }
    
    @Override
    public int compareTo(Car c){
        return out - c.out;
    }
}
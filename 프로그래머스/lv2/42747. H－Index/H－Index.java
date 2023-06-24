import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int N = citations.length;
        int answer = 0;
        for(int i = 0; i < N; i++){
            int h = N - i;
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
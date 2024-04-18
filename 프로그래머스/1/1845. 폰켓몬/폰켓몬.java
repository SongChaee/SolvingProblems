import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i : nums){
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        
        int answer = Math.min(hash.size(), nums.length / 2);
        return answer;
    }
}
import java.util.*;

class Solution {
    public static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    public static ArrayList<String> list;
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        
        for(int len = 1; len <= 5; len++)
            makeWord(len, 0, "");
        
        Collections.sort(list);
        
        int idx = 0;
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).equals(word)){
                idx = i;
                break;
            }
        
        return idx + 1;
    }
    
    public static void makeWord(int N, int idx, String str){
        if(idx >= N){
            list.add(str);
            return;
        }
        
        for(int i = 0; i < 5; i++){
            makeWord(N, idx + 1, str + alphabet[i]);
        }
    }
}
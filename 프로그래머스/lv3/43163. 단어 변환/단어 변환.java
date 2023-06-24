import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // 먼저 words에 target이 있는지 확인
        int count = 0;
        int targetIdx = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                targetIdx = i;
                break;
            }
            else
                count++;
        }
        if(count == words.length)
            return 0;
        
        int answer = 0;
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0, -1));
        
        while(!q.isEmpty()){
            Word check = q.poll();
            // equals 말고 int 값인 target index로 해도 될 듯
            if(check.idx == targetIdx){
                answer = check.cnt;
                break;
            }
            for(int i = 0; i < words.length; i++){
                int wrong = 0;
                if(words[i].length() == check.text.length()){
                    for(int j = 0; j < words[i].length(); j++){
                        if(words[i].charAt(j) != check.text.charAt(j))
                            wrong++;
                    }
                    if(wrong == 1)
                        q.add(new Word(words[i], check.cnt + 1, i));
                }
            }
        }
        
        return answer;
    }
}
class Word{
    String text;
    int cnt;
    int idx;
    public Word(String text, int cnt, int idx){
        this.text = text;
        this.cnt = cnt;
        this.idx = idx;
    }
}
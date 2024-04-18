import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Song>> list = new HashMap<>();
        HashMap<String, Integer> sumPlay = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++){
            int play = plays[i];
            String genre = genres[i];
            Song song = new Song(i, play);
            
            if(!list.containsKey(genre))
                list.put(genre, new ArrayList<>());
            list.get(genre).add(song);
            
            sumPlay.put(genre, sumPlay.getOrDefault(genre, 0) + play);
        }
        
        List<String> keySet = new ArrayList<>(sumPlay.keySet());
        keySet.sort(new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                return sumPlay.get(o2).compareTo(sumPlay.get(o1));
            }
        });
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(String key : keySet){
            Collections.sort(list.get(key));
            int cnt = 0;
            for(Song s : list.get(key)){
                if(cnt >= 2)
                    break;
                ans.add(s.idx);
                cnt++;
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }
}

class Song implements Comparable<Song>{
    String genre;
    int idx;
    int play;
    
    public Song(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song s){
        if(s.play == play)
            return idx - s.idx;
        return s.play - play;
    }
}
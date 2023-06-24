class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int tc = 0; tc < commands.length; tc++){
            int i = commands[tc][0];
            int j = commands[tc][1];
            int k = commands[tc][2];
            
            int len = j - i + 1;
            int[] cut = new int[len];
            int idx = 0;
            for(int a = i-1; a < j; a++)
                cut[idx++] = array[a];
            
            // 정렬
            for(int a = 0; a < len-1; a++){
                int min = cut[a];
                int minIdx = a;
                for(int b = a+1; b < len; b++)
                    if(cut[b] < min){
                        min = cut[b];
                        minIdx = b;
                    }
                int temp = cut[a];
                cut[a] = min;
                cut[minIdx] = temp;
            }
            
            answer[tc] = cut[k-1];
        }
        
        return answer;
    }
}
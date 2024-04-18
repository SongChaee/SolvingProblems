import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number)
            return 1;
        
        ArrayList<Set<Integer>> num = new ArrayList<>();
        for(int i = 0; i <= 8; i++)
            num.add(new HashSet<>());
        
        // N을 한 번만 사용해서 만들 수 있는 숫자
        num.get(1).add(N);
        
        // N을 2번 ~ 8번 사용해서 만들 수 있는 숫자
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        for(int i = 2; i <= 8; i++){
            // 사칙연산 없이 N만 사용해서 만들 수 있는 숫자
            sb.append(N);
            num.get(i).add(Integer.parseInt(sb.toString()));
            
            for(int j = 1; j < i; j++){
                int k = i - j;
                for(int n1 : num.get(j)){
                    for(int n2 : num.get(k)){
                        num.get(i).add(n1 + n2);
                        num.get(i).add(n1 - n2);
                        num.get(i).add(n1 * n2);
                        if(n2 != 0)
                            num.get(i).add(n1 / n2);
                    }
                }
            }
            
            if(num.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
}
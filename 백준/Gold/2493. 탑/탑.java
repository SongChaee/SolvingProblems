import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] ans = new int[N];
		for(int i = 0; i < N; i++) {
			int tower = Integer.parseInt(st.nextToken());
			map.put(tower, i+1);
			
			if(s.isEmpty()) {
				ans[i] = 0;
				s.push(tower);
			} else {
				if(s.peek() < tower) {
					while(s.peek() < tower) {
						s.pop();
						if(s.isEmpty()) {
							ans[i] = 0;
							break;
						}else {
							ans[i] = s.peek();
						}
					}
					s.push(tower);
				} else {
					ans[i] = s.peek();
					s.push(tower);
				}
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			if(ans[i] == 0)
				bw.write("0 ");
			else
				bw.write(map.get(ans[i]) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++)
			q.add(i);
		
		int ans = q.poll();
		if(N==2) ans = q.poll();
		
		while(q.size() > 1) {
			int temp = q.poll();
			q.add(temp);
			q.poll();
			ans = q.peek();
		}
		System.out.println(ans);
	}
}

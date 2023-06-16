import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		// 모든 로프 중량을 큐에 담기
		for(int i = 0; i < num; i++) {
			int weight = Integer.parseInt(br.readLine());
			q.add(weight);
		}
		
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			max = Math.max(max, q.poll() * num--);
		}
		
		System.out.print(max);
	}
}
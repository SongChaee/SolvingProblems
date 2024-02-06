import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty())
					sb.append("0").append("\n");
				else
					sb.append(q.poll()).append("\n");
			} else
				q.add(num);
		}
		
		System.out.print(sb.toString());
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> qp = new PriorityQueue<>();
		PriorityQueue<Integer> qn = new PriorityQueue<>();		
		
		// 숫자 개수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 숫자 N개 입력
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			// 숫자 출력
			if(input == 0) {
				int p = 0;
				int n = 0;
				if(qp.isEmpty() && qn.isEmpty())
					sb.append("0\n");
				else if(qp.isEmpty())
					sb.append(-qn.poll() + "\n");
				else if(qn.isEmpty())
					sb.append(qp.poll() + "\n");
				else {
					p = qp.peek();
					n = qn.peek();
					if(p < n)
						sb.append(qp.poll() + "\n");
					else
						sb.append(-qn.poll() + "\n");
				}
			}
			// 큐에 숫자 삽입
			else {
				if(input < 0)
					qn.add(-input);
				else
					qp.add(input);
			}
		}
		
		// 결과 출력
		System.out.print(sb.toString());
	}
}
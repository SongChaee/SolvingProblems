import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// 연산의 개수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 정수 N개 입력
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			// 절댓값이 가장 작은 값 출력, 해당 값 제거
			if(n == 0) {
				if(q.isEmpty())
					sb.append("0\n");
				else {
					if(q.peek().sign == 1)
						sb.append(q.poll().value + "\n");
					else
						sb.append(-q.poll().value + "\n");
				}
			}
			// 큐에 값 삽입
			else {
				if(n > 0)
					q.add(new Node(n, 1));
				else
					q.add(new Node(-n, -1));
			}
		}
		
		// 결과 출력
		System.out.print(sb.toString());
	}

}

class Node implements Comparable<Node>{
	int value;
	int sign;
	
	public Node(int value, int sign) {
		this.value = value;
		this.sign = sign;
	}
	
	@Override
	public int compareTo(Node n) {
		if(value == n.value) {
			return sign - n.sign;
		}
		return value - n.value;
	}
}
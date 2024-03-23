import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N - 1; i++) {
			q.remove();
		}
		
		System.out.print(q.poll());
	}
}
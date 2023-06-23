import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 반복
		StringTokenizer st;
		int[] stock;
		PriorityQueue<Stock> max;
		for(int tc = 0; tc < T; tc++) {
			// 날의 수
			int N = Integer.parseInt(br.readLine());
			stock = new int[N];
			max = new PriorityQueue<Stock>();
			
			//날 별 주가 입력
			st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0; n < N; n++) {
				stock[n] = Integer.parseInt(st.nextToken());
				max.add(new Stock(n, stock[n]));
			}
			
			// 첫째날부터 주가 탐색
			// 큐의 최댓값과 일치하다면? 가지고 있는 주식을 판다
			// 큐의 최댓값과 일치하지 않는다면? 주식을 산다
			long ans = 0;
			for(int n = 0; n < N; n++) {
				if(stock[n] == max.peek().value) {
					while(max.peek().index <= n && max.size() > 1)
						max.poll();
				}else {
					ans += max.peek().value - stock[n];
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}

class Stock implements Comparable<Stock>{
	int index;
	int value;
	public Stock(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	@Override
	public int compareTo(Stock s) {
		if(value == s.value)
			return index - s.index;
		return s.value - value;
	}
}
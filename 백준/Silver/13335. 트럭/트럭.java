import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());
		
		int[] truck = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			truck[i] = Integer.parseInt(st.nextToken());
		
		if(N == 1) {
			System.out.print(length + 1);
			return;
		}
		
		 Queue<int[]> q = new LinkedList<>();
		 q.add(new int[] {truck[0], length});
		 
		 int time = 1;
		 int weightSum = truck[0];
		 int nextidx = 1;
		 while(!q.isEmpty()) {
			 // 트럭이 다리를 건너왔을 때
			 if(q.peek()[1] == time) {
				 int[] check = q.poll();
				 weightSum -= check[0];
				 if(truck[nextidx] + weightSum <= weight) {
					 q.add(new int[] {truck[nextidx], time + length});
					 weightSum += truck[nextidx];
					 nextidx++;
					 if(nextidx >= N) break;
				 }
			 } 
			 // 트럭이 다리를 건너는 중일 때
			 else {
				 if(truck[nextidx] + weightSum <= weight) {
					 q.add(new int[] {truck[nextidx], time + length});
					 weightSum += truck[nextidx];
					 nextidx++;
					 if(nextidx >= N) break;
				 }
			 }
			 time++;
		 }
		 
		 while(!q.isEmpty()) {
			 time = q.poll()[1];
		 }
		
		 System.out.print(time + 1);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// a : A배열 숫자를 담는 큐
		// b : 존재 여부를 판별할 숫자를 담는 큐
		// map : key 값이 존재하면 value는 1, 아니면 0
		// arr : b에 담기는 숫자를 순서대로 담은 배열
		PriorityQueue<Integer> a = new PriorityQueue<>();
		PriorityQueue<Integer> b = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr;
		
		StringBuilder sb = new StringBuilder();
		
		// A 배열 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int n = 0; n < N; n++)
			a.add(Integer.parseInt(st.nextToken()));
		
		// M개의 수 입력
		int M = Integer.parseInt(br.readLine());
		arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int m = 0; m < M; m++) {
			int input = Integer.parseInt(st.nextToken());
			b.add(input);
			arr[m] = input;
		}
		
		// 존재 여부 판별
		while(!b.isEmpty()) {
			int num = b.poll();
			if(a.isEmpty() || a.peek() > num)
				map.put(num, 0);
			else if(a.peek() == num)
				map.put(num, 1);
			else {
				while(!a.isEmpty() && a.peek() < num)
					a.poll();
				if(a.isEmpty() || a.peek() > num)
					map.put(num, 0);
				else
					map.put(num, 1);
			}
		}
		
		for(int i = 0; i < M; i++)
			sb.append(map.get(arr[i]) + "\n");
		System.out.print(sb.toString());
	}
}
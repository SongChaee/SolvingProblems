import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static Queue<Integer> nums = new LinkedList<>();
	public static int N;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수 입력 받기
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			nums.add(Integer.parseInt(st.nextToken()));
		
		// 연산자 입력 받기
		// 0 : +	1 : -	2 : *	3 : /
		// 사용 가능한 연산자가 0개라면 사용 판별 배열을 true로 설정
		int[] operator = new int[4];
		boolean[] used = new boolean[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
			if(operator[i] == 0)
				used[i] = true;
		}
		
		int[] order = new int[N-1];
		perm(operator, used, order, 0);
		
		System.out.printf("%d\n%d", max, min);
	}
	
	// 연산자 순열 생성 메서드
	// 순열이 완성되면? 해당 수식의 값을 계산하자
	public static void perm(int[] operator, boolean[] used, int[] order, int k) {
		if(k == N - 1) {
			// 수는 N개, 연산자는 N-1개이므로 숫자를 하나 먼저 큐에서 뽑고 수식 시작
			int a = nums.poll();
			nums.add(a);
			int result = a;
			
			for(int i = 0; i < N - 1; i++) {
				int b = nums.poll();
				
				if(order[i] == 0) result += b;
				else if(order[i] == 1) result -= b;
				else if(order[i] == 2) result *= b;
				else result /= b;
				
				nums.add(b);
			}
			
			max = Math.max(max, result);
			min = Math.min(min, result);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(!used[i]) {
				// 해당 연산자를 쓰는 경우
				operator[i]--;
				if(operator[i] == 0)
					used[i] = true;
				order[k] = i;
				perm(operator, used, order, k + 1);
				
				// 해당 연산자를 쓰지 않는 경우
				operator[i]++;
				used[i] = false;
			}
		}
	}
}
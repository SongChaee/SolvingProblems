import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		// 수열 A의 크기와, M값 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		if(M == 0) {
			System.out.print("0");
			return;
		}
		int[] arr = new int[N];
		
		// 수열 A 입력
		for(int n = 0; n < N; n++)
			arr[n] = Integer.parseInt(br.readLine());
		
		// A 오름차순 정렬
		Arrays.sort(arr);
		
		// 투포인터 사용
		int ed = 0;
		int sub = Integer.MAX_VALUE;
		for(int st = 0; st < N; st++) {
			while(ed < N && arr[ed] - arr[st] < M)
				ed++;
			if(ed == N)
				break;
			sub = Math.min(sub, arr[ed] - arr[st]);
		}
		
		System.out.print(sub);
	}
}
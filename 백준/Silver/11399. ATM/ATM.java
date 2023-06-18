import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			time[i] = Integer.parseInt(st.nextToken());
		
		// time 배열 오름차순 정렬
		Arrays.sort(time);
		
		// 최단 시간 연산
		int min = 0;
		for(int i = N; i > 0; i--)
			min += time[N-i] * i;
		
		System.out.print(min);
	}
}
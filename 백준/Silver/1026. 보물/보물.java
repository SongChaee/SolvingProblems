import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		Integer[] arrB = new Integer[N];
		
		// 배열 A와 배열 B 입력받기
		StringTokenizer st;
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				if(i == 0) {
					arrA[j] = Integer.parseInt(st.nextToken());
				}else {
					arrB[j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 배열 A는 오름차순, 배열 B는 내림차순으로 정렬
		Arrays.sort(arrA);
		Arrays.sort(arrB, Collections.reverseOrder());
		
		// S 최솟값 연산
		int min = 0;
		for(int i = 0; i < N; i++)
			min += arrA[i] * arrB[i];
		
		System.out.print(min);
	}
}
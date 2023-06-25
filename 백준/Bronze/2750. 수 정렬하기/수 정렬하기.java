import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 주어진 수열 입력
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		// 선택정렬을 활용한 정렬
		int min, minIdx, temp;
		for(int i = 0; i < N - 1; i++) {
			min = arr[i];
			minIdx = i;
			for(int j = i + 1; j < N; j++)
				if(arr[j] < min) {
					min = arr[j];
					minIdx = j;
				}
			temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		// 오름차순 정렬 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(arr[i]).append("\n");
		System.out.print(sb.toString());
	}
}
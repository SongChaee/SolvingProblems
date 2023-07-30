import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 플로이드 워셜 적용
		int[][] arr = new int[N+1][N+1];
		
		// 구슬의 개수 N의 절반 이상이라는 것 = 해당 구슬이 중간에 위치할 수 없다는 것
		int half = N / 2 + 1;
		
		// 구슬 무게 정보 입력
		// 1인 경우 : x > y
		// -1인 경우 : x < y 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		// a > b이고 b > c라면 a > c임을 표시
		// 또는, a < b이고 b < c라면 a < c임을 표시
		for(int b = 1; b <= N; b++) {
			for(int a = 1; a <= N; a++) {
				for(int c = 1; c <= N; c++) {
					if(arr[c][b] != 0 && arr[a][b] == arr[b][c])
						arr[a][c] = arr[a][b];
				}
			}
		}
		
		// i번 구슬보다 가벼운 구슬의 개수를 담는 배열
		int[] big = new int[N+1];
		// i번 구슬보다 무거운 구슬의 개수를 담는 배열
		int[] small = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(arr[i][j] == 1)
					big[i]++;
				else if(arr[i][j] == -1)
					small[i]++;
			}
		}
		
		// i번째 구슬보다 무겁거나 가벼운 구슬의 개수가 half 이상이라면
		// 중간에 위치할 수 없는 구슬이므로 cnt 1증가
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(big[i] >= half) 
				cnt++;
			if(small[i] >= half)
				cnt++;
		}
		
		System.out.print(cnt);
		
	}
}

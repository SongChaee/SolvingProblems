import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, L, possiblecnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		possiblecnt = 0;
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			if(possible(map[i]))
				possiblecnt++;
		}
		
		int[] temp;
		for(int j = 0; j < N; j++) {
			temp = new int[N];
			for(int i = 0; i < N; i++) {
				temp[i] = map[i][j];
			}
			if(possible(temp))
				possiblecnt++;
		}
		
		System.out.print(possiblecnt);
	}
	
	public static boolean possible(int[] arr) {
		boolean flag = true;
		int temp = arr[0];
		boolean[] install = new boolean[N];
		
		Loop : for(int i = 1; i < N; i++) {  
			if(Math.abs(arr[i] - temp) > 1) {
				flag = false;
				break;
			}
			else if(arr[i] == temp) continue;
			else if(arr[i] - temp == 1) {
				if(i - L >= 0) {
					int j = 1;
					while(j <= L) {
						if(install[i-j] || arr[i-j] != temp) {
							flag = false;
							break Loop;
						}
						install[i-j] = true;
						j++;
					}
					temp = arr[i];
				}
				else {
					flag = false;
					break;
				}
			}
			else if(arr[i] - temp == -1) {
				if(i + L <= N) {
					int j = 0;
					while(j < L) {
						if(install[i+j] || arr[i+j] != arr[i]) {
							flag = false;
							break Loop;
						}
						install[i+j] = true;
						j++;
					}
					temp = arr[i];
				}
				else {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}
}
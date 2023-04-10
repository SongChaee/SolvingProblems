import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int min = Integer.MAX_VALUE;
	public static int cnt1 = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] paper = new boolean[10][10];
		int[] sticker = new int[6];
		Arrays.fill(sticker, 5);
		
		StringTokenizer st;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) {
				if(st.nextToken().equals("1")) {
					paper[i][j] = true;
					cnt1++;
				}
			}
		}
		
		cover(paper, sticker, 0, 0);
		
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.print(min);
	}
	
	public static void cover(boolean[][] arr, int[] sticker, int checknum, int use) {
		if(use >= min) return;
		
		if(checknum == 100) {
			int sum = 0;
			for(int i = 1; i < 6; i++)
				sum += sticker[i];
			min = Math.min(min, 25 - sum);
			
			return;
		}
		
		int x = checknum / 10;
		int y = checknum % 10;
		
		if(!arr[x][y])
			cover(arr, sticker, checknum+1, use);
		else {
			for(int i = 5; i > 0; i--) {
				if(possible(arr, sticker, x, y, i)) {
					paste(arr, x, y, i);
					sticker[i]--;
					cover(arr, sticker, checknum+1, use + 1);
					
					remove(arr, x, y, i);
					sticker[i]++;
				}
			}
		}
		
	}
	
	public static boolean possible(boolean[][] arr, int[] sticker, int x, int y, int n) {
		if(sticker[n] <= 0) return false;
		if(x + n > 10 || y + n > 10)
			return false;
		for(int i = x; i < x + n; i++)
			for(int j = y; j < y + n; j++)
				if(!arr[i][j]) return false;
		return true;
	}
	
	public static void paste(boolean[][] arr, int x, int y, int n) {
		for(int i = x; i < x + n; i++)
			for(int j = y; j < y + n; j++)
				arr[i][j] = false;
	}
	
	public static void remove(boolean[][] arr, int x, int y, int n) {
		for(int i = x; i < x + n; i++)
			for(int j = y; j < y + n; j++)
				arr[i][j] = true;
	}
	
	public static boolean[][] copy(boolean[][] arr){
		boolean[][] c = new boolean[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++)
			c[i] = Arrays.copyOf(arr[i], arr[0].length);
		return c;
	}
	
	public static int[] copy(int[] arr) {
		int[] c = new int[arr.length];
		c = Arrays.copyOf(arr, arr.length);
		return c;
	}
}
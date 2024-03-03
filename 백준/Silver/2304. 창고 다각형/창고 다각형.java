import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] column = new int[1001];
		int left = 1000;
		int right = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int loca = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			column[loca] = height;
			left = Math.min(left, loca);
			right = Math.max(right, loca);
		}
		
		Stack<Integer> s = new Stack<>();
		int temp = column[left];
		for(int i = left + 1; i <= right; i++) {
			if(column[i] < temp)
				s.push(i);
			else {
				while(!s.isEmpty())
					column[s.pop()] = temp;
				temp = column[i];
			}
		}
		
		s = new Stack<>();
		temp = column[right];
		for(int i = right - 1; i >= left; i--) {
			if(column[i] < temp)
				s.push(i);
			else {
				while(!s.isEmpty())
					column[s.pop()] = temp;
				temp = column[i];
			}
		}
		
		int sum = 0;
		for(int i = left; i <= right; i++)
			sum += column[i];
		
		System.out.println(sum);
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int pos = 0;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			arr[i-1] = Integer.parseInt(br.readLine());
			
			if(arr[pos] == i) {
				sb.append("+\n-\n");
				pos++;
			} else {
				stack.push(i);
				sb.append("+\n");
			}
			
			if(!stack.isEmpty() && stack.peek() == arr[pos]) {
				while(!stack.isEmpty() && stack.peek() == arr[pos]) {
					stack.pop();
					sb.append("-\n");
					pos++;
				}
			}
		}
		
		if(pos < n - 1)
			bw.write("NO");
		else bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

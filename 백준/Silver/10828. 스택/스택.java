import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] stack = new int[10000];
	static int pos = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String comm = br.readLine();
			if(comm.charAt(0) == 'p') {
				if(comm.charAt(1) == 'u') {
					StringTokenizer st = new StringTokenizer(comm, " ");
					st.nextToken();
					int num = Integer.parseInt(st.nextToken());
					push(num);
				} else
					bw.write(pop() + "\n");
			} else if(comm.charAt(0) == 's') {
				bw.write(size() + "\n");
			} else if(comm.charAt(0) == 'e') {
				bw.write(empty() + "\n");
			} else
				bw.write(top() + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void push(int x) {
		stack[pos++] = x;
	}
	
	static int pop() {
		if(pos < 1)
			return -1;
		else
			return stack[--pos];
	}
	
	static int size() {
		return pos;
	}
	
	static int empty() {
		if(pos > 0)
			return 0;
		else
			return 1;
	}
	
	static int top() {
		if(pos < 1)
			return -1;
		else
			return stack[pos-1];
	}
}

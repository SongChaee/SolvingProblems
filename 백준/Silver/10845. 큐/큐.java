import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] queue = new int[10000];
	static int head = 0;
	static int tail = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String comm = br.readLine();
			if(comm.contains("push")) {
				StringTokenizer st = new StringTokenizer(comm, " ");
				st.nextToken();
				int input = Integer.parseInt(st.nextToken());
				push(input);
			}
			else if(comm.contains("pop"))
				sb.append(pop()).append("\n");
			else if(comm.contains("size"))
				sb.append(size()).append("\n");
			else if(comm.contains("empty"))
				sb.append(empty()).append("\n");
			else if(comm.contains("front"))
				sb.append(front()).append("\n");
			else
				sb.append(back()).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void push(int x) {
		queue[tail++] = x;
	}
	
	static int pop() {
		if(head == tail)
			return -1;
		else
			return queue[head++];
	}
	
	static int size() {
		return tail - head;
	}
	
	static int empty() {
		if(head == tail)
			return 1;
		else
			return 0;
	}
	
	static int front() {
		if(head == tail)
			return -1;
		else
			return queue[head];
	}
	
	static int back() {
		if(head == tail)
			return -1;
		else
			return queue[tail-1];
	}
}

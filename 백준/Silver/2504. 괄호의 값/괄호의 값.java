import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<Integer> s = new Stack<>();
		
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '(') {
				s.push(-1);
			}
			if(input[i] == '[') {
				s.push(-2);
			}
			if(input[i] == ')') {
				if(!s.isEmpty() && s.peek() == -1) {
					s.pop();
					if(!s.isEmpty() && s.peek() != -1 && s.peek() != -2)
						s.push(s.pop() + 2);
					else 
						s.push(2);
				}else {
					int num = 0;
					while(!s.isEmpty() && s.peek() != -1 && s.peek() != -2)
							num += s.pop();
					if(!s.isEmpty() && s.peek() == -1) {
						s.pop();
						s.push(num * 2);
					}else {
						s.push(-3);
						break;
					}
				}
			}
			if(input[i] == ']') {
				if(!s.isEmpty() && s.peek() == -2) {
					s.pop();
					if(!s.isEmpty() && s.peek() != -1 && s.peek() != -2)
						s.push(s.pop() + 3);
					else
						s.push(3);
				}else {
					int num = 0;
					while(!s.isEmpty() && s.peek() != -1 && s.peek() != -2)
						num += s.pop();
					if(!s.isEmpty() && s.peek() == -2) {
						s.pop();
						s.push(num * 3);
					} else {
						s.push(-3);
						break;
					}
				}
			}
		}
		if(s.contains(-1) || s.contains(-2) || s.contains(-3))
			System.out.println("0");
		else {
			int sum = 0;
			while(!s.isEmpty())
				sum += s.pop();
			System.out.println(sum);
		}
	}
}

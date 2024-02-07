import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		for(int n = 0; n < input.length; n++) {
			// 숫자인 경우
			if(input[n] >= 'A' && input[n] <= 'Z')
				sb.append(input[n]);
			
			// 연산자인 경우
			else {
				// 소괄호인 경우
				if(input[n] == '(')
					s.push(input[n]);
				else if(input[n] == ')') {
					while(!s.isEmpty() && s.peek() != '(')
						sb.append(s.pop());
					if(!s.isEmpty())
						s.pop();
				}
				// 사칙연산인 경우
				else {
					while(!s.isEmpty() && prior(s.peek()) >= prior(input[n]))
						sb.append(s.pop());
					s.push(input[n]);
				}
			}
		}
		
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		
		System.out.print(sb.toString());
	}
	
	// 연산자 우선순위 결정 메서드
	public static int prior(char op) {
		if(op == '(' || op == ')')
			return 0;
		else if(op == '+' || op == '-')
			return 1;
		else if(op == '*' || op == '/')
			return 2;
		
		return -1;
	}
}
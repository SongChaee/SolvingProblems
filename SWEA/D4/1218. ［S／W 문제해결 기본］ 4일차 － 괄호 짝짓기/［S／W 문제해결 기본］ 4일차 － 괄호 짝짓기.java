import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int len = Integer.parseInt(sc.nextLine());
			char[] input = new char[len];
			input = sc.nextLine().toCharArray();
			
			Stack<Character> s = new Stack<>();
			s.push(input[0]);
			for(int i = 1; i < input.length; i++) {
				if(input[i] == '(' || input[i] == '{' || input[i] == '[' || input[i] == '<') 
					s.push(input[i]);
				else if(input[i] == ')') {
					if(s.peek() == '(') s.pop();
					else break;
				}
				else if(input[i] == '}'){
					if(s.peek() == '{') s.pop();
					else break;
				}
				else if(input[i] == ']'){
					if(s.peek() == '[') s.pop();
					else break;
				}
				else{
					if(s.peek() == '<') s.pop();
					else break;
				}
			}
			
			if(s.isEmpty())
				System.out.printf("#%d 1\n", tc);
			else
				System.out.printf("#%d 0\n", tc);
		}
	}
}

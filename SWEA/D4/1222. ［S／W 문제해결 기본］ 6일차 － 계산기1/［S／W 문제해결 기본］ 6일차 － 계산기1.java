import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int len = sc.nextInt();
			char[] arr = new char[len];
			arr = sc.next().toCharArray();
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '+') {
					while(!stack.isEmpty())
						sb.append(stack.pop());
					stack.push(arr[i]);
				}else sb.append(arr[i]);
			}
			sb.append(stack.pop());
			
			char[] postfix = sb.toString().toCharArray();
			Stack<Integer> intStack = new Stack<>();
			
			for(int i = 0; i < postfix.length; i++) {
				if(postfix[i] == '+') {
					int b = intStack.pop();
					int a = intStack.pop();
					intStack.push(a+b);
				} else intStack.push(postfix[i] - '0');
			}
            
			System.out.printf("#%d %d\n", tc, intStack.pop());
		}
	}
}
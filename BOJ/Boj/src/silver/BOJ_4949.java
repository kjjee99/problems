package silver;

/*
 * 괄호 짝맞추기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			
			if(s.equals("."))	return;
			System.out.println(solve(s));
		}
	}
	
	private static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(' || s.charAt(i) == '[')	stack.push(s.charAt(i));
			else if(s.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(') return "no";
				else									stack.pop();
			}
			else if(s.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() != '[') return "no";
				else									stack.pop();
			}
		}
		if(stack.isEmpty())	return "yes";
		else 				return "no";
	}

}

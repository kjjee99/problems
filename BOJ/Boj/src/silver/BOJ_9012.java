package silver;

/*
 * 괄호 짝 맞추기
 * 스택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N--> 0) {
			String str = br.readLine();
			Stack<Character> s = new Stack<>();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ')' && !s.isEmpty()) {
					if(s.peek() == '(')		s.pop();
				}
				else						s.push(str.charAt(i));
			}
			if(s.isEmpty())		System.out.println("YES");
			else				System.out.println("NO");
		}
	}

}

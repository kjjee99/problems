package silver;

/*
 * 0일 때 pop, 아닐 때 추가
 * 스택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		while(N--> 0) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0)	s.pop();
			else		s.push(x);
		}
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		
		System.out.println(sum);
	}

}

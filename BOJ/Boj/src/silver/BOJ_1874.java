package silver;
/*
 * 스택수열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		ArrayList<Character> list = new ArrayList<>();
		int index = 1;
		int number = 1;
		
		while(number <= N) {
			stack.push(number);
			list.add('+');
			while(true) {
				if(stack.isEmpty() || input[index] != stack.peek())	break;
				stack.pop();
				list.add('-');
				index++;
			}
			number++;
		}
		
		if(stack.isEmpty()) {
			for(int i = 0; i< list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		else	System.out.println("NO");
		
	}

}

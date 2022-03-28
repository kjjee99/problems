package silver;

/*
 * 카드 섞기
 * deque
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_2164 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<>();
		for(int i = N; i >= 1; i--) {
			q.push(i);
		}
		
		while(q.size() != 1) {
			q.pop();
			q.addLast(q.pop());
		}
		System.out.println(q.peek());
	}

}

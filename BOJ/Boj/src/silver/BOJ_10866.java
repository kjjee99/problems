package silver;

/*
 * deque 기본
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866 {
	private static Deque<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int number = 0;
			if(st.hasMoreTokens())	number = Integer.parseInt(st.nextToken());
			switch(command) {
			case "push_front": q.addFirst(number); break;
			case "push_back": q.addLast(number); break;
			case "pop_front": pop_front(); break;
			case "pop_back": pop_back(); break;
			case "size" : System.out.println(q.size()); break;
			case "empty": empty(); break;
			case "front": front(); break;
			case "back": back(); break;
			}
		}
	}
	
	private static void pop_front() {
		if(q.isEmpty())	System.out.println(-1);
		else			System.out.println(q.pollFirst());
	}
	private static void pop_back() {
		if(q.isEmpty())	System.out.println(-1);
		else			System.out.println(q.pollLast());
	}
	private static void empty() {
		if(q.isEmpty())	System.out.println(1);
		else			System.out.println(0);
	}
	
	private static void front() {
		if(q.isEmpty())	System.out.println(-1);
		else			System.out.println(q.getFirst());
	}
	
	private static void back() {
		if(q.isEmpty())	System.out.println(-1);
		else			System.out.println(q.getLast());
	}

}

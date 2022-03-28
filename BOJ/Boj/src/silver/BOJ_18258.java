package silver;
/*
 * deque 기본
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18258 {
	private static Integer[] list = new Integer[2000000];
	private static int size = 0;
	private static int front = 0, back = 0;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String execution = st.nextToken();
			int number = 0;
			if(st.hasMoreTokens())	number = Integer.parseInt(st.nextToken());
			switch (execution) {
				case "push":	push(number); break;
				case "pop":		pop(); break;
				case "front": 	front(); break;
				case "back": 	back(); break;
				case "size": 	size(); break;
				case "empty":	empty(); break;
			}
			
		}
		System.out.println(sb);
		
	}
	
	private static void push(int number) {
		list[back] = number;
		back++;
		size++;
	}
	
	private static void pop() {
		if(size == 0)	sb.append(-1).append('\n');
		else {
			sb.append(list[front]).append('\n');
			size--;
			front++;
		}
	}
	
	private static void front() {
		if(size == 0)	sb.append(-1).append('\n');
		else			sb.append(list[front]).append('\n');
	}
	
	private static void back() {
		if(size == 0)	sb.append(-1).append('\n');
		else {
			sb.append(list[back - 1]).append('\n');
		}
	}
	
	private static void size() {
		sb.append(size).append('\n');
	}
	
	private static void empty() {
		if(size == 0)	sb.append(1).append('\n');
		else			sb.append(0).append('\n');
	}

}

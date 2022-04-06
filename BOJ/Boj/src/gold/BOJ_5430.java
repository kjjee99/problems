package gold;

/*
 * 덱으로 만드는 새로운 함수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430 {
	private static StringBuilder sb = new StringBuilder();
	private static String command = "";
	private static Deque<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T--> 0) {
			command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			for(int i = 0; i < N; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			function();
		}
		
		System.out.println(sb);
	}
	
	private static void function() {
		boolean direction = true;
		for(int i = 0; i < command.length(); i++) {
			if(command.charAt(i) == 'R') {
				direction = !direction;
			}
			else if(command.charAt(i) == 'D') {
				if(q.isEmpty())	{
					sb.append("error\n");
					return;
				}
				if(direction == true) 	q.pollFirst();
				else 					q.pollLast();
			}
				
		}
		sb.append('[');
		while(!q.isEmpty()) {
			if(direction == true) 	sb.append(q.pollFirst());
			else					sb.append(q.pollLast());
			if(!q.isEmpty())		sb.append(',');
		}
		sb.append("]\n");
	}

}

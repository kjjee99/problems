package silver;
/*
 * 요세푸스 문제
 * deque
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.addLast(i);
		}
		int index = 1;
		while(q.size() != 1) {
			if(index % K == 0)	sb.append(q.pop()).append(", ");
			else				q.addLast(q.pollFirst());
			index++;
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}

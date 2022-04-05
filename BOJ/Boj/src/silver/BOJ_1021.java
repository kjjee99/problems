package silver;

/*
 * 회전하는 큐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
	private static LinkedList<Integer> q = new LinkedList<>();
	private static int cnt = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		for(int i = 0; i < M; i++) {
			if(check(arr[i])) {
				while(arr[i] != q.get(0)) {
					q.addLast(q.pollFirst());
					cnt++;
				}
			}
			else {
				while(arr[i] != q.get(0)) {
					q.addFirst(q.pollLast());
					cnt++;
				}
			}
			q.poll();
		}
		System.out.println(cnt);
	}
	
	private static boolean check(int n) {
		for(int i = 0; i  <= q.size()/2; i++) {
			if(n == q.get(i))	return true;
		}
		return false;
	}

}

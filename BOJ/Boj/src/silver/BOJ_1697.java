package silver;

/*
 * 거리이동
 * bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	private static int visited[] = new int[100001];
	private static int K;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());	//수빈이의 위치
		K = Integer.parseInt(st.nextToken()); 	//동생의 위치
		
		System.out.println(bfs(X));
	}
	
	private static int bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node] = 1;
		int n = 0;
		while(!q.isEmpty()) {
			n = q.poll();
			if(n == K)	return (visited[n] - 1);
			if(n >= 1 && visited[n - 1] == 0) {
				visited[n - 1] = visited[n] + 1;
				q.add(n - 1);
			}
			if(n + 1 <= 100000 && visited[n + 1] == 0) {
				visited[n + 1] = visited[n] + 1;
				q.add(n + 1);
			}
			if(2 * n <= 100000 && visited[2*n] == 0) {
				visited[n * 2] = visited[n] + 1;
				q.add(2 * n);
			}
		}
		return -1;
	}

}

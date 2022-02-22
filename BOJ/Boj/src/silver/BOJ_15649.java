package silver;

/*
 * N과 M
 * BackTracking + DFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N];
		dfs(N, M, 0);
		
		System.out.println(sb);
		
	}
	
	private static void dfs(int N, int M, int depth) {
		//depth가 M과 같을 때
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			//방문하지 않았을 때, visited[i] = false일 때
			if(!visited[i]) {
				
				visited[i] = true;		//방문상태로 변경
				arr[depth] = i + 1;		//해당 깊이를 index로 하여 (i + 1)로 저장
				dfs(N, M, depth + 1);	//다음 자식 노드 방문을 위해 + 1
				
				//자식노드 방문이 끝나고 돌아오면 방문하지 않은 상태로 변경
				visited[i] = false;
			}
		}
		
	}

}

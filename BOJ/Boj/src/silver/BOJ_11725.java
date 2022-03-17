package silver;

/*
 * 이진트리의 부모 찾기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
	private static boolean[] visited;
	private static ArrayList<Integer>[] list;
	private static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		list = new ArrayList[N + 1];
		parents = new int[N + 1];
		
		//배경을 만들어 주기 위한 초기화
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i])		dfs(i);
		}
		for(int i = 2; i <= N; i++)
			System.out.println(parents[i]);
	}

	private static void dfs(int node) {
		if (visited[node])		return;
		
		visited[node] = true;
		for (int item : list[node]) {
			if (!visited[item]) {
				parents[item] = node;
				dfs(item);
			}
		}
	}

}

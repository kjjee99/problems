package gold;

/*
 * 트리의 지름(가중치)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
	// ArrayList array
	private static ArrayList<int[]>[] graph;
	// 방문 배열
	private static boolean[] visited;
	// 가장 긴 지름
	private static int max = 0;
	// 1번에서 가장 먼 노드
	private static int maxIdx = 1;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정점 개수
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		
		// ArrayList initialize
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 부모
			int parent = Integer.parseInt(st.nextToken());
			// 자식
			int child = Integer.parseInt(st.nextToken());
			// 가중치
			int weight = Integer.parseInt(st.nextToken());
			
			// ArrayList 안에 숫자 배열 삽입
			graph[parent].add(new int[] {child, weight});
			graph[child].add(new int[] {parent, weight});
		}
		
		// 제일 먼 노드 검색
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);
		
		// 제일 먼 노드에서 가장 긴 지름 구하기
		visited = new boolean[n + 1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.println(max);
	}
	
	private static void dfs(int x, int count) {
		if(max < count) {
			max = count;
			maxIdx = x;
		}
		
		// node[0] = index
		// node[1] = weight
		for(int[] node : graph[x]) {
			// 방문하지 않았을 때
			if(!visited[node[0]]) {
				visited[node[0]] = true;
				dfs(node[0], count + node[1]);
			}
		}
	}

}

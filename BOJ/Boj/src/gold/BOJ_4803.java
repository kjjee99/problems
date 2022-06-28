package gold;

/*
 * 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4803 {
	private static int[][] tree;
	// 방문했는지 확인
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// case number
		int caseNum = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 정점
			int n = Integer.parseInt(st.nextToken());
			// 간선의 개수
			int m = Integer.parseInt(st.nextToken());
			
			// 0 0 이 입력되면 종료
			if(n == 0 && m == 0)	break;
			
			// 1부터 시작
			tree = new int[n + 1][n + 1];
			visited = new boolean[n + 1];
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				tree[x][y] = tree[y][x] = 1;
			}
			
			// 트리의 개수
			int cnt = 0;
			for(int i = 1; i <= n; i++) {
				if(!visited[i]) {
					// 사이클이 아닌 경우만 개수 증가
					if(dfs(i, i))	cnt++;
				}
			}
			
			// 기본값은 트리가 없는 경우
			String result = "No trees.";
			if(cnt == 1) {
				result = "There is one tree.";
			}
			else if(cnt > 1) {
				result = "A forest of "+cnt+" trees.";
			}
			
			System.out.println("Case "+caseNum+": "+result);
			caseNum++;
		}
	}
	
	private static boolean dfs(int root, int index) {
		visited[index] = true;
		
		for(int i = 1; i < visited.length; i++) {
			if(i == root) continue;
			if(tree[index][i] == 1)	{
				// 방문한 적이 있으면 사이클 존재
				if(visited[i])	return false;
				if(!dfs(index, i)) return false;
			}
		}
		return true;
	}

}

package silver;

/*
 * 미로찾기 - 최단경로검색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int[][] graph;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};	//상하
	static int[] dy = {0, 0, -1, 1};	//좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(graph[n-1][m-1]);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		//queue가 비어있을 때까지
		while(!queue.isEmpty()) {
			//현재 위치
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			//[열][행] = [y][x]
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				//위치에서 벗어날 때
				if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)	continue;
				//그래프에서 0이거나 이미 방문한 기록이 있을 때
				if(visited[nextY][nextX] || graph[nextY][nextX] == 0)	continue;
				
				queue.add(new int[] {nextX, nextY});
				//횟수++
				graph[nextY][nextX] = graph[nowY][nowX]++;
				//방문 처리
				visited[nextY][nextX] = true;
			}
		}
	}
	
}

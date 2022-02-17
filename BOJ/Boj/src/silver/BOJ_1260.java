package silver;

/*
 * DFS & BFS 기본 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	private static int nV;				//시작점
	private static int n;				//정점
	private static int m;				//간선
	private static int[][] graph;		//그래프
	private static boolean[] visited;	//방문 기록
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nV = Integer.parseInt(st.nextToken());
		
		//좌표를 그대로 입력하기 위해 +1, (0,-)(-,0)은 비워둠
		graph = new int[1001][1001];
		
		//간선 연결상태
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x]  = 1;
		}
		
		visited = new boolean[1001];
		DFS(nV);
		System.out.println();
		BFS();
		
	}
	
	//DFS
	//재귀함수
	public static void DFS(int index) {
		
		
		visited[index] = true;
		System.out.print(index+" ");
		
		for(int j = 1; j <= n; j++) {
			if(graph[index][j] == 1 && visited[j] == false) {
				DFS(j);
			}
		}
		
	}
	
	//BFS
	public static void BFS() {
		visited = new boolean[1001];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(nV);		//시작점도 Queue에 삽입
		visited[nV] = true;
		System.out.print(nV+" ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int j = 1; j <= n; j++) {
				if(graph[temp][j] == 1 && visited[j] == false) {
					queue.offer(j);
					visited[j]  = true;
					System.out.print(j + " ");
				}
			}
		}
	}

}

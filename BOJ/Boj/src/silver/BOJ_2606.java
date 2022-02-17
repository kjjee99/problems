package silver;

/*
 * 바이러스_DFS
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {
	static int[][] graph;
	static boolean[] visited;
	static int computer;
	static int line;
	static int result = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		computer = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		line = Integer.parseInt(st.nextToken());
		
		graph = new int[computer+1][computer+1];
		visited = new boolean[computer+1];
//		graph = new int[101][101];
//		visited = new boolean[101];
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(1);
		
		System.out.println(result);
	}
	
	public static void dfs(int i) {
		visited[i] = true;
		result++;
		
		for(int j = 1; j <= computer; j++) {
			if(graph[i][j] == 1 && visited[j] == false)		
				dfs(j);
		}
	}

}

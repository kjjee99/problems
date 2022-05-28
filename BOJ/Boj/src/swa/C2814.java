package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2814 {
	private static boolean[] visited;
	private static int max = 0;
	private static int N = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			max = 0;
			//N개의 정점, M개의 간선 무방향 그래프
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N + 1];
			map = new int[N + 1][N + 1];
			//간선 정보
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = map[y][x] = 1;
			}
			
			//정점이 1부터 시작
			for(int i = 1; i <= N; i++) {
					dfs(i, 1);
					visited[i] = false;
			}
			
			System.out.println("#"+testCase+" "+max);
			
		}
	}
	
	private static void dfs(int idx, int cnt) {
		visited[idx] = true;
		for(int i = 1; i <= N; i++) {
			if(map[idx][i] == 1 && !visited[i]) {
				dfs(i, cnt+1);
				visited[i] = false;
			}
		}
		max = Math.max(max, cnt);
	}

}

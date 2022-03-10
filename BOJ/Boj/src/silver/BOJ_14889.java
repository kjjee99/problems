package silver;

/*
 * 팀 능력치 차이
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	private static int[][] map;
	private static boolean visited[];
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N + 1];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, N, 0);
		System.out.println(min);
		
	}
	
	private static void dfs(int at, int n, int depth) {
		if(depth == n / 2) {
			difference(n);
			return;
		}
		for(int i = at; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i + 1, n, depth + 1);
				visited[i] = false;
			}
		}
	}
	private static void difference(int N) {
		int start = 0, link = 0;
		
		for(int i = 0; i < N -1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(visited[i] && visited[j]) 
					start += map[i][j] +  map[j][i];
				else if(!visited[i] && !visited[j])
					link += map[i][j] + map[j][i];
			}
		}
		int val = Math.abs(start - link);
		min = Math.min(val, min);
	}

}

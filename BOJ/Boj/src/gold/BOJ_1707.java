package gold;

/*
 * 이분 그래프
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1707 {
	private static int[] colors;
	private static List<Integer>[] list;
	private static boolean isBinary;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int k = Integer.parseInt(br.readLine());
		
		while(k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 정점의 개수
			int V = Integer.parseInt(st.nextToken());
			// 간선의 개수
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V + 1];
			for(int i = 0; i <= V; i++) {
				list[i] =new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				 st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				list[u].add(v);
				list[v].add(u);
			}
			
			// 노드 번호마다 색을 칠함
			colors = new int[V + 1];
			// 이분 그래프
			isBinary = true;
			for(int i = 1; i <= V; i++) {
				// 이분 그래프가 아닐 때
				if(!isBinary)	break;
				if(colors[i] == 0)	dfs(i, 1);
			}
			
			System.out.println(isBinary ? "YES" : "NO");
		}
		
	}
	
	private static void dfs(int x, int color) {
		colors[x] = color;
		
		for(int value : list[x]) {
			if(colors[value] == color)	{
				isBinary = false;
				return;
			}
			if(colors[value] == 0)	dfs(value, color * -1);
		}
	}

}

package gold;

/*
 * 사이클 게임
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 점의 개수
		// 0 ~ n - 1
		int n = Integer.parseInt(st.nextToken());
		// 차례의 수
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// union하기 전 root 노드가 같을 때 게임 종료
			if(find(x) == find(y)) {
				System.out.println(i);
				return;
			}
			union(x, y);
		}
		System.out.println(0);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y)	parent[x] = y;
		else		parent[y] = x;
	}
	
	private static int find(int index) {
		if(index == parent[index]) 	return index;
		return parent[index] = find(parent[index]);
	}

}

package gold;

/*
 * 여행계획
 * 유니온 파인드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//도시의 수
		int N = Integer.parseInt(br.readLine());
		// 여행계획에 속한 도시들의 수 
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		// initialize
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int x = Integer.parseInt(st.nextToken());
				
				// 1일 때만 연결
				if(x == 1) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < M; i++) {
			int now = find(Integer.parseInt(st.nextToken()));
			
			// 루트 노드가 다를 때
			if(start != now) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y)	parent[x] = y;
		else		parent[y] = x;
	}
	
	private static int find(int index) {
		if(parent[index] == index) return index;
		return parent[index] = find(parent[index]);
	}

}

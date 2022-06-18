package gold;

/*
 * 집합의 표현
 * 유니온 파인드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// n+1개의 집합
		int n = Integer.parseInt(st.nextToken());
		// 연산의 개수
		int m = Integer.parseInt(st.nextToken());
		
		// 부모 노드
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 0 = 합집합(union)
			// 1 = 찾기(find)
			int x = Integer.parseInt(st.nextToken());
			
			// 두 원소 입력
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 찾을 때 출력
			if(x == 1) {
				if(find(a) == find(b))	System.out.println("YES");
				else					System.out.println("NO");
			}
			// 합집합
			else {
				union(a, b);
			}
		}
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 높은 값이 부모 노드
		if(a > b)	parent[a] = b;
		else		parent[b] = a;
	}
	
	private static int find(int index) {
		// 자기 자신일 때는 root node
		if(parent[index] == index) return index;
		
		return parent[index] = find(parent[index]);
	}

}

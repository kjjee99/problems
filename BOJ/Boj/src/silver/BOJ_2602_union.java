package silver;

/*
 * 1번 컴퓨터를 통해 바이러스에 걸린 컴퓨터 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2602_union {
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 컴퓨터의 수
		int computer = Integer.parseInt(br.readLine());
		// 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
		int connect = Integer.parseInt(br.readLine());
		
		parent = new int[computer + 1]; 
		
		//초기화
		for(int i = 1; i <= computer; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= connect; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 합집합 연산
			union(x, y);
		}
		
		int cnt = 0;
		for(int i = 2; i <= computer; i++) {
			// 1번 컴퓨터로부터 감염된 수
			if(find(i) == find(1)) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 두 값의 루트가 같으면 이미 같은 트리
		// 높이가 더 낮은 트리를 높은 트리 밑에 넣음
		// x의 root를 y로 변경
		if(x > y)	parent[x] = y;
		// y의 root를 x로 변경
		else		parent[y] = x;
	}
	
	private static int find(int index) {
		// 자기 자신
		if(index == parent[index])	return index;
		// 경로 압축(Path compression)
		//find하면서 만난 모든 값의 부모 노드를 루트로 만듦
		return parent[index] = find(parent[index]);
	}

}

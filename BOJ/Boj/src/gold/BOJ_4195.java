package gold;

/*
 * 친구 네트워크
 * 해시맵 사용해서 유니온 파인드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
	// root node
	private static int[] parent;
	// tree level
	private static int[] level;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T--> 0) {
			int n = Integer.parseInt(br.readLine());
			// 최대 친구의 수 = n * 2
			parent = new int[n * 2];
			level = new int[n * 2];
			
			for(int i = 0; i < n * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			// 친구 번호 매기기
			int idx = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String person1 = st.nextToken();
				String person2 = st.nextToken();
				
				// 입력받은 값이 존재하지 않을 때 해시 맵에 저장
				if(!map.containsKey(person1)) 	map.put(person1, idx++);
				if(!map.containsKey(person2)) 	map.put(person2, idx++);
				
				System.out.println(union(map.get(person1), map.get(person2)));
			}
		}
	}
	
	private static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		// 항상 x < y
		if(x != y) {
			parent[y] = x;
			// 트리의 레벨 계산
			level[x] += level[y];
		}
		return level[x];
	}
	
	private static int find(int index) {
		if(index == parent[index])	return index;
		return parent[index] = find(parent[index]);
	}

}

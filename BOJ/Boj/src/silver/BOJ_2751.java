package silver;

/*
 * 수 정렬
 * 시간초과가 날 수 있기 때문에 시간복잡도 계산을 잘 하는 것이 중요
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] count = new boolean[2000001];
		for(int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		//array for문 참고
		//for(int i : count)	sb.append((i - 1000000) + "\n");
		
		//계수 정렬
		for(int i = 0; i < count.length; i++) {
			if(count[i])	sb.append((i - 1000000)).append('\n');
		}
		
		System.out.println(sb);
		
	}
}

package silver;

/*
 * 수 정렬_계수정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int count[] = new int[10001];
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			count[x]++; 
		}
		
		br.close();
		
		for(int i = 1; i < count.length; i++) {
			while(count[i]-->0)
				sb.append(i+"\n");
		}
		System.out.println(sb);
	}

}

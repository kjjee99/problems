package silver;

/*
 * 00타일과 1타일로 원하는 길이만큼의 타일 만들기
 * 동적계획법
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result[] = new int[N + 1];
		
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			result[i] = (result[i - 1] + result[i - 2]) % 15746;
		}
		System.out.println(result[N]);
	}
	

}

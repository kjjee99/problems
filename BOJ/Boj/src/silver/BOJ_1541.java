package silver;

/*
 * 괄호 없는 계산식
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//초기 상태 확인 여부
		int N = Integer.MAX_VALUE;
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		
		while(sub.hasMoreElements()) {
			int temp = 0;
			StringTokenizer addition = new StringTokenizer(sub.nextToken(), "+");
			
			while(addition.hasMoreElements()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			//첫 번째 토큰인 경우 temp의 값이 첫 번째 수가 됨
			if(N == Integer.MAX_VALUE)		N = temp;
			else							N -= temp;
			
		}
		
		System.out.println(N);
		
	}

}

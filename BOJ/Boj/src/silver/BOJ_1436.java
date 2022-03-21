package silver;

/*
 * 666이 들어간 숫자 찾기
 * 브루트포스
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int number = 666;
		while(cnt != n) {
			number++;
			if(String.valueOf(number).contains("666")) {
				cnt++;;
			}
		}
		System.out.println(number);
	}

}

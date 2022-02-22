package silver;

/*
 * 1로 만들기
 * dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		System.out.println(dp(X, 0));
		
	}

	private static int dp(int x, int count) {
		if(x < 2)	return count;
		
		return Math.min(dp(x /2, count + 1 +(x % 2)), dp(x / 3, count + 1 + (x % 3)));
	}
	
}

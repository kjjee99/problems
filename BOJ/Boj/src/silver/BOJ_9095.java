package silver;

/*
 * 1, 2, 3 더하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	private static int dp[] = new int[11];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];		//점화식
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

}

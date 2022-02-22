package silver;

/*
 * fibonacci
 * dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
	static Integer[][] dp = new Integer[41][2];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0][0] = 1; dp[1][1] = 1;
		dp[0][1] = 0; dp[1][0] = 0;
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			System.out.println(dp[N][0] +" "+dp[N][1]);
		}
	}
	
	private static Integer[] fibo(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
			dp[n][1] = fibo(n - 1)[0] + fibo(n - 2)[1];
		}
		
		return dp[n];
	}
}

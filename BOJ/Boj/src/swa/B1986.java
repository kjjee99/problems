package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1986 {
	private static int[] dp = new int[11];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		zigzag();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println("#"+testCase+" "+dp[N]);
		}
	}
	
	private static void zigzag() {
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i < 11; i++) {
			if(i % 2 == 0) 	dp[i] = dp[i - 1] - i;
			else 			dp[i] = dp[i - 1] + i;
		}
	}

}

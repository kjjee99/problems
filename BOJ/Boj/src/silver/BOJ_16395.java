package silver;

/*
 * 파스칼의 삼각형
 * dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16395 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[31][31];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		for(int i = 3; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		System.out.println(dp[N][K]);
	}

}

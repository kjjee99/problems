package bronze;

/*
 * (x + y) ^ n이라는 이항식에서 k번째 항의 이항계수 
 * 이항계수 설명: https://rh-tn.tistory.com/32
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_11050 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(binomial(n, k));
	}
	
	//재귀
	public static int recur_bonomial(int n, int r) {
		if(r == 0 || n == r)
			return 1;
		return recur_bonomial(n - 1, r - 1) + recur_bonomial(n - 1, r);
	}
	
	//동적계획법(Bottom-up)
	static int[][] dp = new int[10][10];
	public static int binomial(int n, int r) {
		int i= 0, j = 0;
		for(i = 0; i <= n; i++) {
			for(j = 0; j <= Math.min(i, r); j++) {
				if(j == 0 || j == i)	dp[i][j] = 1;
				else					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		return dp[n][r];
	}

}

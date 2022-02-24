package bronze;

/*
 * fibonacci 수 찾기
 * 90일 때, '2880067194370816120'
 * int 자료형으로 계산할 수 없는 값이므로 long 자료형 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {
	private static Long dp[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Long[n + 1];
		
		dp[0] = (long) 0;
		dp[1] = (long) 1;
		
		System.out.println(fibo(n));
	}
	
	private static long fibo(int n) {
		if(dp[n] == null)	dp[n] = fibo(n - 1) + fibo(n - 2);
		return dp[n];
	}

}

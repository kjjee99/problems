package silver;

/*
 * 지붕 RGB
 * 동적계획법
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	private static int[][] houses;
	private static int[][] dp;
	private static final int RED = 0;
	private static final int GREEN = 1;
	private static final int BLUE = 2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		houses = new int[number][3];
		dp = new int[number + 1][3];
		for(int i = 0; i < number; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][RED] = houses[0][RED];
		dp[0][GREEN] = houses[0][GREEN];
		dp[0][BLUE] = houses[0][BLUE];
		
		System.out.println(Math.min(painting(number - 1, RED), Math.min(painting(number - 1, GREEN), painting(number - 1, BLUE))));;
	}
	
	private static int painting(int idx, int prev) {
		if(dp[idx][prev] == 0) {
			if (prev == RED) {
				dp[idx][RED] = Math.min(painting(idx - 1, GREEN), painting(idx - 1, BLUE)) + houses[idx][RED];
			}
			if (prev == GREEN) {
				dp[idx][GREEN] = Math.min(painting(idx - 1, RED), painting(idx - 1, BLUE)) + houses[idx][GREEN];
			}
			if (prev == BLUE) {
				dp[idx][BLUE] = Math.min(painting(idx - 1, GREEN), painting(idx - 1, RED)) + houses[idx][BLUE];
			}
		}
		
		return dp[idx][prev];
	}

}

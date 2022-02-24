package silver;

/*
 * 정수 삼각형
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
	private static int tri[][];
	private static Integer dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tri = new int[n][n];
		dp = new Integer[n][n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			dp[n - 1][i] = tri[n - 1][i];
		}
		
		System.out.println(sum(0, 0));
	}
	
	private static int sum(int depth, int side) {
		if(depth == dp.length - 1)		return dp[depth][side];
		if(dp[depth][side] == null)		dp[depth][side] = Math.max(sum(depth + 1, side), sum(depth + 1, side + 1)) + tri[depth][side];
		return dp[depth][side];
	}

}

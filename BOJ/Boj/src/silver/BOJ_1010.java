package silver;

//겹치지 않게 다리 설치하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
	
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop = Integer.parseInt(br.readLine());
		while(loop > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(combi(b, a));
			loop--;
		}
	}
	
	public static int combi(int a, int b) {
		//원래 있던 것
		if(dp[a][b] > 0)
			return dp[a][b];
		
		//1개만 존재
		if(a == b || b == 0)
			return dp[a][b] = 1;
		
		//결과
		return dp[a][b] = combi(a - 1, b - 1) + combi(a - 1, b);
	}

}

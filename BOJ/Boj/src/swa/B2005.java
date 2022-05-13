package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2005 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] tri = new int[N+1][N+1];
			tri[1][1] = 1;
			if(N >= 2) {
				tri[2][1] = 1;
				tri[2][2] = 1;
			}
			for(int i = 3; i <= N; i++) {
				for(int j = 1; j <= i; j++) {
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
				}
			}
			
			//result
			System.out.println("#"+testCase);
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= i; j++) {
					System.out.print(tri[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}

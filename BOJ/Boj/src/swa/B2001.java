package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2001 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int row = 0; row <= N - M; row++) {
				for(int col = 0; col <= N - M; col++) {
					int nx = row + M;
					int ny = col + M;
					int result = 0;
					for(int x = row; x < nx; x++) {
						for(int y = col; y < ny; y++)
							result += map[x][y];
					}
					max = Math.max(max, result);
				}
			}
			System.out.println("#"+testCase+" "+max);
		}
	}

}

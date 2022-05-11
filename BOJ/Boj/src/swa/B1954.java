package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1954 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int size = N;
			int cnt = 1;
			int right = -1;
			int bottom = 0;
			int top = 1;
			/*
			 * int row = 0, col = 0; int width = N; int height = N - 1; while(cnt <= N * N)
			 * { for(int k = 0; k < width; k++) { snail[row][col] = cnt; col++; cnt++; }
			 * width--; row++; col--; for(int k = 0; k < height; k++) { snail[row][col] =
			 * cnt; row++; cnt++; } height--; col--; row--; for(int k = 0; k < width; k++) {
			 * snail[row][col] = cnt; col--; cnt++; } width--; col++; row--; for(int k = 0;
			 * k < height; k++) { snail[row][col] = cnt; row--; cnt++; } height--; col++;
			 * row++;
			 * 
			 * }
			 */
			while(cnt <= N * N) {
				for(int col = 0; col < size; col++) {
					right += top;
					snail[bottom][right] = cnt;
					cnt++;
				}
				size--;
				for(int col = 0; col < size; col++) {
					bottom += top;
					snail[bottom][right] = cnt;
					cnt++;
				}
				top *= -1;
			}
			
			//result
			System.out.println("#"+testCase);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}

package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			int total = 0;
			int idx = N / 2;
			for(int i = 0; i < idx; i++) {
				for(int j = idx - i; j < idx + i + 1; j++) {
					total += map[i][j];
				}
			}
			for(int i = idx; i >= 0; i--) {
				for(int j = idx - i; j <= idx + i; j++) {
					total += map[N - i - 1][j];
				}
			}
			
			System.out.println("#"+testCase+" "+total);
		}
	}

}

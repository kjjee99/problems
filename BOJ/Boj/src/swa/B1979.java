package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1979 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					st = new StringTokenizer(br.readLine());
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int total = 0;
			for(int row = 0; row < N; row++) {
				int count = 0;
				for(int col = 0; col < N; col++) {
					if(map[row][col] == 0) {
						if(count == K)	total++;
						count = 0;
					}else {
						count++;
					}
				}
				if(count == K)	total++;
			}
			for(int col = 0; col < N; col++) {
				int count = 0;
				for(int row = 0; row < N; row++) {
					if(map[row][col] == 0) {
						if(count == K)	total++;
						count = 0;
					}else {
						count++;
					}
				}
				if(count == K)	total++;
			}
			System.out.println("#"+testCase+" "+total);
		}
	}

}

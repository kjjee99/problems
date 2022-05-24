package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1209 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[101][101];
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][100] += map[i][j];
					map[100][j] += map[i][j];
				}
			}
			int max = 0;
			for(int i = 0; i < 100; i++) {
				max = Math.max(max, Math.max(map[100][i], map[i][100]));
			}
			System.out.println("#"+T+" "+max);
		}
	}

}

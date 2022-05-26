package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1220 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());
			int[][] table = new int[100][100];
			for(int i = 0; i < 100; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int col = 0; col < 100; col++) {
				boolean start = false;
				for(int row = 0; row < 100; row++) {
					int idx = table[row][col];
					if(idx == 1) {
						start = true;
					}
					else if(idx == 2 && start) {
						start = false;
						cnt++;
					}
				}
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}

}

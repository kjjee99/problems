package silver;
/*
 * 별찍기10
 * 분할정복&재귀
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2447 {
	private static char[][] stars;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		stars = new char[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		triple(0,0,N);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	private static void triple(int startX, int startY, int cnt) {
		if(cnt == 1) {
			stars[startX][startY] = '*';
			return;
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != 1 || j != 1) {
					triple(startX + i * (cnt/3), startY + j * (cnt/3), cnt/3);
				}
			}
		}
	}

}

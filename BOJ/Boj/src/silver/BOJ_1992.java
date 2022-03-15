package silver;

/*
 * 쿼드 트리
 * 분할정복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		partition(0, 0, N);
	}
	
	private static void partition(int row, int col, int size) {
		if(isSame(row, col, size)) {
			
			System.out.print(map[row][col]);
			return;
		}
		
		int newSize = size / 2;
		
		System.out.print("(");
		partition(row, col, newSize);						//2사분면
		partition(row, col + newSize, newSize);				//1사분면
		partition(row + newSize, col, newSize);				//3사분면
		partition(row + newSize, col + newSize, newSize); 	//4사분면
		System.out.print(")");
	}
	
	private static boolean isSame(int row, int col, int size) {
		int color = map[row][col];
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != color)	return false;
			}
		}
		return true;
	}

}

package gold;

/*
 * 스도쿠 채우기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
	private static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i  < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for(int j = 0; j < 9; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		sudoku(0, 0);
		
	}
	
	private static void sudoku(int col, int row) {
		if(col == 9) {
			sudoku(0, row + 1);
			return;
		}
		
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			//상황종료
			System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i = 1; i < 10; i++) {
				if(possibility(col, row, i)) {
					map[row][col] = i;
					sudoku(col + 1, row);
				}
			}
			map[row][col] = 0;
			return;
		}
		
		sudoku(col + 1, row);
		
	}
	
	private static boolean possibility(int col, int row, int number) {
		//행
		for(int i = 0; i < 9; i++) {
			if(map[row][i] == number)
				return false;
		}
		//열
		
		for(int i = 0; i < 9; i++) {
			if(map[i][col] == number)	return false;
		}
		//3*3
		int x = (row / 3) * 3;
		int y = (col / 3) * 3;
		
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				if(map[i][j] == number) return false;
			}
		}
		
		return true;
	}

}

package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1974 {
	private static int[][] numbers = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (sudoku())
				System.out.println("#" + testCase + " " + 1);
			else
				System.out.println("#" + testCase + " " + 0);
		}
	}

	private static boolean sudoku() {
		boolean[] checked;
		// 행
		for (int i = 0; i < 9; i++) {
			checked = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (checked[numbers[i][j] - 1] == true) {
					return false;
				} else
					checked[numbers[i][j] - 1] = true;
			}
		}

		// 열
		for (int i = 0; i < 9; i++) {
			checked = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (checked[numbers[j][i] - 1]) {
					return false;
				} else
					checked[numbers[j][i] - 1] = true;
			}
		}

		// 3*3
		for (int i = 0; i < 6; i += 3) {
			for(int j = 0; j < 6; j += 3) {
				checked = new boolean[10];
				int r = i + 3;
				int c = j + 3;
				for(int a = i; a < r; a++) {
					for(int b = j; b < c; b++) {
						if(checked[numbers[a][b] - 1])	return false;
						else							checked[numbers[a][b] - 1] = true;
					}
				}
			}
		}
		return true;
	}
}

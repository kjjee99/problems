package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] rot90 = new int[N][N];
			int[][] rot180 = new int[N][N];
			int[][] rot270 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			rot90 = Rotation(map);
			rot180 = Rotation(rot90);
			rot270 = Rotation(rot180);
			
			System.out.println("#"+testCase);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(rot90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rot180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rot270[i][j]);
				}
				System.out.println();
			}
		}
		
	}
	private static int[][] Rotation(int[][] arr) {
		int n = arr.length;
		int[][] result = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				result[col][row] = arr[n - row - 1][col];
			}
		}
		return result;
	}

}

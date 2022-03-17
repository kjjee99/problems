package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
	private static int[][] map;
	private static int[] result = new int[3];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, N);
		for(int res : result)
			System.out.println(res);
	}

	private static void partition(int row, int col, int size) {
		if(isSameColor(row, col, size)) {
			if(map[row][col] == -1)			result[0]++;
			else if(map[row][col] == 0)		result[1]++;
			else							result[2]++;
			return;
		}
		
		int newSize = size / 3;
		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row, col + newSize * 2, newSize);
		partition(row + newSize, col + newSize * 2, newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize * 2, col, newSize);
		partition(row + newSize * 2, col + newSize, newSize);
		partition(row + newSize, col + newSize, newSize);
		partition(row + newSize *2, col + newSize *2, newSize);
	}
	
	private static boolean isSameColor(int row, int col, int size) {
		int color = map[row][col];
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != color) return false;
			}
		}
		return true;
	}
}

package bronze;

//k층 n호에 거주하려면 (k-1)층 1호~n호까지의 주민의 합을 데려와야 함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop = Integer.parseInt(br.readLine());
		int[][] list = new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			list[i][1] = 1;
			list[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 2; j < 15; j++)
				list[i][j] = list[i][j - 1] + list[i - 1][j];
		}
		while(loop > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			
			System.out.println(list[k][n]);
			loop--;
		}
	}

}

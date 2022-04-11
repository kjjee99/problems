package gold;
/*
 * nQueen
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	private static int N, count = 0;
	private static int[] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		//index == column
		//value == row
		map = new int[N];
		
		nQueen(0);
		System.out.println(count);
	}
	
	private static void nQueen(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		for(int i = 0; i < N; i++) {
			map[depth] = i;
			if(possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	private static boolean possibility(int depth) {
		for(int i = 0; i < depth; i++) {
			//같은 행에 있는지 확인
			if(map[depth] == map[i])	return false;
			//대각선에 있는지 확인(col && row 모두 1씩 차이남)
			else if(Math.abs(depth - i) == Math.abs(map[depth] - map[i]))	return false;
		}
		return true;
	}

}

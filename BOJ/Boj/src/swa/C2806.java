package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C2806 {
	private static int[] map;
	private static int count;
	private static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			/*
			 * 같은 행이나 열에 퀸이 있을 수 없으므로
			 * index를 열(column)으로 사용
			 * value를 행(row)로 사용
			 * */
			map = new int[N];
			//initialize
			count = 0;
			nQueen(0);
			System.out.println("#"+testCase+" "+count);
		}
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
			//대각선에 있는지 확인
			else if((Math.abs(depth - i) == Math.abs(map[depth] - map[i]))) return false;
		}
		return true;
	}

}

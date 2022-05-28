package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C5215 {
	private static int N = 0;
	private static int[][] ingredients;
	private static int answer = 0;
	private static int calory = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			calory = Integer.parseInt(st.nextToken());
			
			ingredients = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			hamburger(0, 0, 0);
			System.out.println("#"+testCase+" "+answer);
		}
		
	}
	
	//부분 집합
	private static void hamburger(int idx, int score, int totalCal) {
		if(idx == N) {
			if(totalCal <= calory)
				answer = Math.max(answer, score);
			return;
		}
		
		hamburger(idx + 1, score + ingredients[idx][0], totalCal + ingredients[idx][1]);
		hamburger(idx + 1, score, totalCal);
	}

}

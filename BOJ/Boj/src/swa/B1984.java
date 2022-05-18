package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1984 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] scores = new int[10];
			for(int i = 0; i < 10; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(scores);
			double sum = 0;
			for(int i = 1; i < 9; i++) {
				sum += scores[i];
			}
			System.out.println("#"+testCase+" "+ (int)Math.round(sum/8));
		}
	}

}

package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1983 {

	public static void main(String[] args) throws IOException{
		final String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Integer[] scores = new Integer[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				scores[i] = a * 35 + b * 45 + c * 20;
			}
			int student_score = scores[K - 1];
			Arrays.sort(scores, Collections.reverseOrder());
			int rank = Arrays.asList(scores).indexOf(student_score);
			rank = rank * 10 / N;
			System.out.println("#"+testCase+" "+ grades[rank]);
		}
	}

}

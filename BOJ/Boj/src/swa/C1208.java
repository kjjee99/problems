package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1208 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] heights = new int[100];
			for(int i = 0; i < 100; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(heights);
			for(int i = 0; i < count; i++) {
				heights[0]++;
				heights[99]--;
				Arrays.sort(heights);
			}
			
			System.out.println("#"+testCase+" "+(heights[99] - heights[0]));
		}
	}

}

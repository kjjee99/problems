package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1204 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase--> 0) {
			int T = Integer.parseInt(br.readLine());
			int[] count = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 1000; i++) {
				int score = Integer.parseInt(st.nextToken());
				count[score]++;
			}
			int max = 0;
			for(int i = 0; i < 100; i++) {
				if(count[i] >= count[max])
					max = i;
			}
			System.out.println("#"+T+" "+max);
		}
	}
}

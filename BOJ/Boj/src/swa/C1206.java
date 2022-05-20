package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1206 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase < 11; testCase++) {
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] buildings = new int[size];
			for(int i = 0; i < size; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i = 2; i < size - 2; i++) {
				int max = 
						Math.max(buildings[i - 2], Math.max(buildings[i - 1], Math.max(buildings[i + 1], buildings[i + 2])));
				if(buildings[i] > max) {
					cnt += buildings[i] - max;
				}
				
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}

}

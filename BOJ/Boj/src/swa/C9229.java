package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C9229 {

	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T= Integer.parseInt(br.readLine());
			
			for(int testCase = 1; testCase <= T; testCase++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				
				int[] snacks = new int[N];
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					snacks[i] = Integer.parseInt(st.nextToken());
				}
				int result = -1;
				int sum = 0;
				
				for(int i = 0; i < N - 1; i++) {
					for(int j = i + 1; j < N; j++) {
						sum = snacks[i] + snacks[j];
						if(sum <=M && result < sum)	result = sum;
					}
				}
				System.out.println("#"+testCase+" "+result);
			}
	}

}

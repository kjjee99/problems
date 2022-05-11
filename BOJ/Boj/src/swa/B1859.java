package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1859 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			int days = Integer.parseInt(br.readLine());
			int[] prices = new int[days];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < days; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			int max = prices[days - 1];
			long price = 0;
			for(int idx = days - 2; idx >= 0; idx--) {
				if(max < prices[idx])	max = prices[idx];
				else {
					price += max - prices[idx];
				}
			}
			
			System.out.println("#"+test+" "+price);
			
		}
	}

}

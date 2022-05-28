package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1289 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			int cnt = 0;
			if(input.charAt(0) == '1')	cnt = 1;
			for(int i = 0; i < input.length() - 1; i++) {
				if(input.charAt(i) != input.charAt(i + 1)) cnt++;
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}

}

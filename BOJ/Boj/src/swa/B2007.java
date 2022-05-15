package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2007 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			for(int i = 1; i <= 10; i++) {
				String result = input.substring(0, i);
				String b = input.substring(i, i + i);
				if(result.equals(b))	{
					System.out.println("#"+testCase+" "+result.length());
					break;
				}
			}
			
		}
	}

}

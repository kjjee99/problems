package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1213 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());
			String search = br.readLine();
			String str = br.readLine();
			
			int count = -1;
			int result = 0;
			while((count = str.indexOf(search, count + 1)) >= 0) result++;
			
			System.out.println("#"+T+" "+(result));
		}
	}

}

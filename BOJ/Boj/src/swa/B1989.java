package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1989 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String word = br.readLine();
			boolean twin = true;
			int length = word.length();
			for(int i = 0; i < length; i++) {
				if(word.charAt(i) != word.charAt(length - i - 1)){
					twin = false;
					break;
				}
			}
			System.out.print("#"+testCase+" ");
			if(twin)	System.out.println(1);
			else		System.out.println(0);
		}
	}

}

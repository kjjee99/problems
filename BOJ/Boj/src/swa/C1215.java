package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1215 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int len = Integer.parseInt(br.readLine());
			char[][] abc = new char[8][8];
			for(int i = 0; i < 8; i++) {
				String input = br.readLine();
				abc[i] = input.toCharArray();
			}
			System.out.println("#"+testCase+" "+palindrome(len, abc));
		}
	}
	
	private static int palindrome(int len, char[][] abc) {
		int count = 0;
		for(int i = 0; i < 8; i++) {
			//행
			for(int j = 0; j <= 8 - len; j++) {
				boolean isSame = true;
				for(int k = 0; k < len / 2; k++) {
					if(abc[i][j + k] != abc[i][j + len - k - 1]){
						isSame = false;
						break;
					}
					System.out.println(count);
				}
				if(isSame)	count++;
			}
		}
		
		for(int j = 0; j < 8; j++) {
			for(int i = 0; i <= 8 - len; i++) {
				boolean isSame = true;
				for(int k = 0; k < len / 2; k++) {
					if(abc[i + k][j] != abc[i + len - k - 1][j]){
						isSame = false;
						break;
					}
				}
				if(isSame)	count++;
			}
		}
		return count;
	}

}

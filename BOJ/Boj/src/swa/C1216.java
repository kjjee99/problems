package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1216 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());
			char[][] map = new char[100][100];
			for(int i = 0; i < 100; i++) {
				String input = br.readLine();
				map[i] = input.toCharArray();
			}
			int answer = 0;
			
			for(int len = 0; len < map.length; len++) {
				//col
				for(int i = 0; i < map.length; i++) {
					for(int j = 0; j <= map.length - len; j++) {
						boolean check = true;
						for(int k = 0; k < len/2; k++) {
							//다를 때
							if(map[i][j + k] != map[i][j + len - k - 1]) {
								check = false;
								break;
							}
						}
						//최대 길이
						if(check && answer < len) answer = len;
					}
				}
				//row
				for(int j = 0; j < map.length; j++) {
					for(int i = 0; i <= map.length - len; i++) {
						boolean check = true;
						for(int k = 0; k < len/2; k++) {
							if(map[i + k][j] != map[i + len - k - 1][j]) {
								check = false;
								break;
							}
						}
						if(check && answer < len) answer = len;
					}
				}
			}
			
			System.out.println("#"+testCase+" "+answer);
		}
	}

}

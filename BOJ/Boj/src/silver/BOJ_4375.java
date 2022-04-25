package silver;
/*
 * 1로 이루어진 배수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String N = br.readLine();
			if(N == null) {
				break;
			}
			int n = Integer.parseInt(N);
			int num = 0;
			for(int i = 1; i <= n; i++) {
				num = num * 10 + 1;
				num %= n;
				if(num == 0) {
					System.out.println(i);
					break;
				}
			}
			
		}
	}

}

package silver;
/*
 * 골드바흐의 추측
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int p = n / 2;
			int q = n / 2;
			while(true) {
				if(prime(p) && prime(q)) {
					System.out.println(p + " " + q);
					break;
				}
				p--;
				q++;
			}
		}
	}

	private static boolean prime(int n) {
		//제곱근을 사용하면 시간이 더 줄어듬.
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)	return false;	
		}
		return true;
	}
}

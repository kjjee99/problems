package silver;

/*
 * a ^ b % c
 * 분할정복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		System.out.println(result(a % c, b, c));
	}
	
	private static long result(long a, long b, long c) {
		if(b == 1)		return a % c;
		
		long temp = result(a, b / 2, c) % c;
		
		//짝수
		if(b % 2 == 0)	return (temp * temp) % c;
		//홀수
		else			return (((temp * temp) % c) * a) % c;
	}

}

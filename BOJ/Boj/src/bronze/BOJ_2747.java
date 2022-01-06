package bronze;
/*
 * 피보나치 수열
 * n번째 수 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2747 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int number = Integer.parseInt(st.nextToken());
		int result = Fibo(number);
		System.out.println(result);
	}
	
	static int Fibo(int n) {
		int[] arr = { 0, 1, 0 };
		if(n == 1) return 1;
		if(n == 0) return 0;
		for(int i = 0; i < n-1; i++) {
			arr[2] = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = arr[2];
		}
		return arr[2];
	}

}

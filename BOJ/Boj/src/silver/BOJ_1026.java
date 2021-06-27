package silver;

//두 배열의 원소를 곱해 최소 합을 구해라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int i = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(i= 0; i< n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(i= 0; i< n; i++) {
			
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int result = 0;
		for(i = 0; i < n; i++) {
			result += A[i] * B[n - i - 1];
		}
		System.out.println(result);
	}

}

package silver;
/*
 * 숫자 카드2
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int findNumber = Integer.parseInt(st.nextToken());
			sb.append(upperBound(findNumber) - lowerBound(findNumber)).append(' ');
		}
		
		System.out.println(sb);
	}

	private static int lowerBound(int number) {
		int low = 0;
		int high = arr.length;
		while (low < high) {
			//범위를 초과할 수 있음
			int mid = (high - low) / 2 + low;
			if (number <= arr[mid]) 	high = mid;
			else						low = mid + 1;
		}
		return low;
	}

	private static int upperBound(int number) {
		int low = 0;
		int high = arr.length;
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (number < arr[mid]) 		high = mid;
			else						low = mid + 1;
		}
		
		return high;
	}

}

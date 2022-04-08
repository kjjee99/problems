package silver;

/*
 * 랜선 자르기
 * 이분탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
	private static int[] lines;
	private static int N, max;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new int[K];
		max = 0;
		
		for(int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[i]);
		}
		
		System.out.println(binarySearch());
	}

	private static long binarySearch() {
		long low = 1;
		long high = max;
		while(low <= high) {
			long mid = (high - low) /2 + low;
			long cnt = 0;
			for(int line : lines) {
				cnt += line / mid;
			}
			//upper Bound
			if(cnt < N)	high = mid -1;
			else		low = mid + 1;
		}
		return high;
	}
	
	/*
	 * 입력
	 * 2 2
	 * 1
	 * 1
	 * 출력 = 1;
	 */
}

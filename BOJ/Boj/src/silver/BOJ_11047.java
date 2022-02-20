package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동전 합 맞추기
 */

public class BOJ_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coins[] = new int[N];
		int result = 0;

		for(int i = (N - 1); i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int coin : coins) {
			if(K < coin) continue;
			result += K / coin;
			K = K % coin;
//			K -= (K / coin) * coin;
		}
		
		System.out.println(result);
	}

}

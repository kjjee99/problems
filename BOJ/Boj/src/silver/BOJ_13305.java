package silver;
/*
 * 도시 간 이동할 때 주유
 * 그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[] link = new long[N - 1];
		long[] cities = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			link[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			cities[i] = Long.parseLong(st.nextToken());
		}

		long oth = cities[0];
		long money = 0;
		for (int i = 0; i < N - 1; i++) {
			if(cities[i] < oth)
				oth = cities[i];
			money += oth * link[i];
		}

		System.out.println(money);
	}

}

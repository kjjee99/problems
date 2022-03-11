package silver;

/*
 * 패션
 * 조합&해쉬맵
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375 {
	private static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int K = Integer.parseInt(br.readLine());
			
			while (K-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}

			int result = 1;
			for (int val : map.values())
				result *= val + 1;
			System.out.println(result - 1);
			map.clear();
		}
	}
}

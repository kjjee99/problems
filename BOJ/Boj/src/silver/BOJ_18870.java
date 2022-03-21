package silver;
/*
 * 좌표 압축
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] copyArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = copyArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(copyArr);
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for(int number : copyArr) {
			if (!map.containsKey(number)) {
				map.put(number, cnt);
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int number : arr) {
			sb.append(map.get(number)).append(' ');
		}
		System.out.println(sb);
	}

}

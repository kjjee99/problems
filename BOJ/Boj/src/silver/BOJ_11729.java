package silver;

/*
 * Hanoi Tower
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = (int) (Math.pow(2, N) - 1);
		sb.append(count).append('\n');
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	private static void hanoi(int number, int from, int by, int to) {
		if(number == 1) {
			sb.append(from+" "+to).append('\n');
			return;
		}
		
		hanoi(number - 1, from, to, by);
		sb.append(from+" "+to).append('\n');
		hanoi(number - 1, by, from, to);
	}
}

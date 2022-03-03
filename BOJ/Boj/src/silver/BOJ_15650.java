package silver;
/*
 * N과 M(2)
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(1, N, M, 0);
		System.out.println(sb);
	}

	private static void dfs(int at, int n, int m, int depth) {
		if(depth == m) {
			for(int value : arr) {
					sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = at; i <= n; i++) {
				arr[depth] = i;
				dfs(i + 1, n, m, depth + 1);
		}
	}
}

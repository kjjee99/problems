package silver;

/*
 * N과 M(3)
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(N,M,0);
		System.out.println(sb);
	}
	
	private static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int value : arr) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[depth] = i + 1;
			dfs(n, m, depth+1);
		}
	}
}

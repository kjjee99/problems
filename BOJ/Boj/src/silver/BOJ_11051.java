package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
	private static final int div = 10007;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		System.out.println(combi(N) * mod_inverse((combi(N - K) * combi(K)) % div, div - 2) % div);
		int[][] tri = new int[N + 1][N + 1];
		
		//파스칼의 삼각형
		for(int i = 0; i < tri.length; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0)	tri[i][j] = 1;
				else					tri[i][j] = (tri[i - 1][j - 1] + tri[i - 1][j]) % 10007;
			}
		}
		System.out.println(tri[N][K]);
	}
	
	/*
	private static int combi(int n) {
		if(n <= 1)	return 1;
		return (combi(n - 1) * n) % div;
	}

	private static int mod_inverse(int a, int p) {
		int ret = 1;
		while(p > 0) {
			//페르마의 소정리
			if(p % 2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			a *= a;
			a %= div;
			p >>= 1;	//p = p /2
		}
		return ret;
	}*/
}

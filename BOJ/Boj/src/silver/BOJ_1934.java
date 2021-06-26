package silver;

//최소공배수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		while(num > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			gcd(a,b);
			num--;
		}
	}
	
	//euclidean algorithm
	public static void gcd(int a, int b) {
		int t1 = a, t2 = b;
		
		while(t2 != 0) {
			int r = t1 % t2;
			
			t1 = t2;
			t2 = r;
		}
		
		System.out.println((a * b)/t1);
	}

}

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = 1, lcm = 1;
		int i = 2;
		
		while(i <= a && i <= b) {
			if(a % i == 0 && b % i == 0) {
				gcd = i;
			}
			i++;
		}
		
		lcm = (a * b) / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
		
	}

}

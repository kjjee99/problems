package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		int max = 0;
		
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int off = Integer.parseInt(st.nextToken());
			int on = Integer.parseInt(st.nextToken());
			total +=on - off;
			max = Math.max(total, max);
		}
		
		System.out.println(max);
	}

}

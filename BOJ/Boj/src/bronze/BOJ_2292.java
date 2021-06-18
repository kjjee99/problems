package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; ; i++) {
			if(i * ( (i - 1) * 6) / 2 + 1>= number) {
				System.out.println(i);
				break;
			}
			
		}
	}

}

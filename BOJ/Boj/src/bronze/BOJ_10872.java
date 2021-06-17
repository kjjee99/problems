package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int result = 1;
		
		while(number > 0) {
			result *= number;
			number--;
		}
		
		System.out.println(result);
	}

}

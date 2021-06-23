package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());

		int[] fibonacci = new int[number + 1];

		for (int i = 0; i < number + 1; i++) {
			if (i == 0)
				fibonacci[0] = 0;
			else if (i == 1)
				fibonacci[1] = 1;
			else {
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			}
		}
		System.out.println(fibonacci[number]);
	}

}

package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int loop = Integer.parseInt(br.readLine());
		int[] input = new int[3];
		while(loop > 0) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			if(input[2] % input[0] == 0) {
				System.out.println((input[0]) * 100 + (input[2] / input[0]));
			}
			else {
				System.out.println((input[2] % input[0]) * 100 + (input[2] / input[0] + 1));
			}
			
			loop--;
		}
	}

}

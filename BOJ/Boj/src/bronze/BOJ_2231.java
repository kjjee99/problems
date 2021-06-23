package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_n = br.readLine();
		
		int len = str_n.length();
		
		int n = Integer.parseInt(str_n);
		int result = 0, temp = 0;
		
		for(int i = (n - len*9); i < n; i++) {
			int num = i;
			temp = 0;
			while(num != 0) {
				temp += num % 10;
				num /= 10;
			}
			if(temp + i == n) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

}

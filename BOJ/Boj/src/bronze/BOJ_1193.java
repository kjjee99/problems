package bronze;

//수정 必
//분수찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine()); 
		
		int count = 1, sum = 0;
		
		while(true) {
			if(number <= sum + count) {
				if(count % 2 == 1) {
					System.out.println((count - (number - sum -1)) +"/"+ (number - sum));
					break;
				}else {
					System.out.println((number - sum) +"/"+(count - (number - sum - 1)));
					break;
				}
			}else {
				sum += count;
				count++;
			}
		}
	}

}

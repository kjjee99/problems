package bronze;

/*
 * 거스름돈_greedy
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5585 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int change = Integer.parseInt(st.nextToken());
		int coin[] = {500, 100, 50, 10, 5, 1};
		
		int result = 0;
		
		change = 1000 - change;
		
		for(int i = 0; i < 6; i++) {
			if(change / coin[i] > 0 ) {
				result += change / coin[i];
				change = change % coin[i];
			}
		}
		
		/*
		for(int i = 0; i < 6; i++) {
			int number = change / coin[i];
			result += number;
			change -= number * coin[i];
		}*/
		
		System.out.println(result);
		
	}

}

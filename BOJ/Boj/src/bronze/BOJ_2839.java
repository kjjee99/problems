package bronze;

//5와 3으로 최소로 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839 {
	public static BufferedReader sc = new BufferedReader (new InputStreamReader(System.in));
	
	//greedy
	/*public static void main(String[] args) throws IOException{
		int sugar = Integer.parseInt(sc.readLine());
		int bag = 0;
		while (sugar >= 0) {
			if(sugar % 5 == 0) {
				bag += sugar / 5;
				break;
			}
			sugar -= 3;
			bag++;
		}
		if(sugar < 0) 	bag = -1;
		System.out.println(bag);
	}*/
	
	//dp
	public static void main(String[] args) throws IOException{
		int sugar = Integer.parseInt(sc.readLine());
		if(sugar < 5) {
			if(sugar == 3)		System.out.println(1);
			else				System.out.println(-1);
			return;
		}
		
		int dp[] = new int[sugar + 1];
		Arrays.fill(dp, 9999);
		dp[3] = 1;
		dp[5] = 1;
		for(int i = 6; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
		}
		if(dp[sugar] > 9999) {
			System.out.println(-1);
		}else {
			System.out.println(dp[sugar]);
		}
	}

	/*public static void main(String[] args) throws NumberFormatException, IOException {
		int sugar = Integer.parseInt(sc.readLine());
		int bag = 0;
		while (sugar > 0) {
			if (sugar % 5 == 0) {
				sugar -= 5;
				bag++;
			} else if (sugar % 3 == 0) {
				sugar -= 3;
				bag++;
			} else if (sugar > 5) {
				sugar -= 5;
				bag++;
			} else {
				bag = -1;
				break;
			}
		}
		System.out.println(bag);
	}*/

}

package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1926 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			String num = String.valueOf(i);
			if(num.contains("3") || num.contains("6") || num.contains("9"))
				game(num);
			else
				System.out.print(i+" ");
		}
	}
	
	public static void game(String num) {
		for(int j = 0; j < num.length(); j++) {
			char check = num.charAt(j);
			if(check == '3' || check == '6' || check == '9')
				System.out.print("-");
		}
		System.out.print(" ");
	}
}

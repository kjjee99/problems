package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3053 {
	public static double PI = 3.14159265358979323846;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int radius = Integer.parseInt(br.readLine());
		
		System.out.println(String.format("%.6f", radius * radius * PI));
		System.out.println(String.format("%.6f", (double)(radius * radius * 2)));
	}
}

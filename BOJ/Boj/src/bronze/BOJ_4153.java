package bronze;

//직각 삼각형인지 확인

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		int side1 = 0, side2 = 0, side3 = 0;
		int i = 0;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			side1 = Integer.parseInt(st.nextToken());
			side2 = Integer.parseInt(st.nextToken());
			side3 = Integer.parseInt(st.nextToken());
			if(side1 == 0 && side2 == 0 && side3 == 0) break;
			rightTriangle(side1, side2, side3);
		}
	}
	
	public static void rightTriangle(int s1, int s2, int s3) {
		if(s1 * s1 == s2 * s2 + s3 * s3)
			System.out.println("right");
		else if(s2 * s2 == s1 * s1 + s3 * s3)
			System.out.println("right");
		else if(s3 * s3 == s2 * s2 + s1 * s1)
			System.out.println("right");
		else
			System.out.println("wrong");
	}

}

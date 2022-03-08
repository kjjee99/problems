package bronze;

/*
 * 사각형 만들기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] points = new int[4][2];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		//x
		if(points[0][0] == points[1][0])
			points[3][0] = points[2][0];
		else if(points[0][0] == points[2][0])
			points[3][0] = points[1][0];
		else
			points[3][0] = points[0][0];
		
		//y
		if(points[0][1] == points[1][1])
			points[3][1] = points[2][1];
		else if(points[0][1] == points[2][1])
			points[3][1] = points[1][1];
		else
			points[3][1] = points[1][1];
		System.out.println(points[3][0] +" "+points[3][1]);
	}

}

package bronze;

//테두리에 더 가까운 거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int[] input = new int[4];
		for(int i = 0; i < 4; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int width = Math.min(input[2] - input[0], input[0]);
		int height = Math.min(input[1], input[3] - input[1]);
		System.out.println(Math.min(width, height));
	}

}

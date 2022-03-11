package silver;

/*
 * 기약분수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3036 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int parent = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N - 1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int child = 0;
		for(int value : arr) {
			child = fraction(parent, value);
			System.out.println(parent / child +"/"+ value / child);
		}
	}
	private static int fraction(int a, int b) {
		while(true) {
			int temp = a % b;
			if(temp == 0) 	return b;
			a = b;
			b = temp;
		}
	}

}

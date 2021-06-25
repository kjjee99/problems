package bronze;

//블랙잭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st =new StringTokenizer(br.readLine());
		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0, temp = 0;
		for(int i = 0; i < n - 2; i++) {
			if(input[i] > m) continue;
			for(int j = i + 1; j < n - 1; j++) {
				if(input[i] + input[j] > m) continue;
				for(int k = j + 1; k < n; k++) {
					temp = input[i] + input[j] + input[k];
					if(temp == m) {
						result = temp;
						break;
					}
					if(result < temp && temp < m) result = temp;
				}
			}
		}
		System.out.println(result);
	}

}

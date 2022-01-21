package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int number = Integer.parseInt(st.nextToken());
		int input[][] = new int[number][2];
		for(int i = 0; i < number; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < number; i++) {
			int rank = 1;
			
			for(int j = 0; j < number; j++) {
					if(i == j)	continue;
					if(input[i][0] < input[j][0] && input[i][1] < input[j][1])
						rank++;
			}
			
			System.out.print(rank+" ");
		}
		
		
		
	}

}

package silver;


/*
 * https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4
 * "에라토스테네스의 체"라는 소수찾는 방법
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1929 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());

		int[] input = new int[2];
		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		
		ArrayList<Boolean> al = new ArrayList<Boolean>(input[1] + 1);
		
		al.add(false);
		al.add(false);
		
		int i = 2;
		
		for(i = 2; i < input[1] + 1; i++)
			al.add(i, true);
		
		for(i = 2; i * i < input[1] + 1; i++) {
			if(al.get(i)) {
				for(int j = i * i; j < input[1] + 1; j += i)
					al.set(j, false);
			}
		}
		for(i = input[0]; i < input[1] + 1; i++) {
			if(al.get(i))
				System.out.println(i);
		}
	}

}

package silver;

/*
 * 문자열 길이가 짧은 순대로 정렬
 * Override를 통해 비교함수 재정의
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		String[] str = new String[number];
		
		for(int i = 0; i < number; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				//길이가 같을 경우
				if(arg0.length() == arg1.length())		return arg0.compareTo(arg1);
				//그 외의 경우
				else									return arg0.length() - arg1.length();
				/*
				 * 양수일 때 arg0가 큰 값, 0일 때 같은 값, 음수일 때 arg1이 큰 값으로 정렬된다.
				 */
			}
			
		});
		System.out.println(str[0]);
		for(int i = 1; i < number; i++) {
			//중복X
			if(!str[i].equals(str[i - 1])) {
				System.out.println(str[i]);
			}
		}
	}

}

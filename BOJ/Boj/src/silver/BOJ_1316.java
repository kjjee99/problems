package silver;

/*
 * 그룹단어체커
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		while(N--> 0) {
			String s = br.readLine();
			if(check(s)) {
				count++;
			}
		}
		System.out.println(count);
	}
	private static boolean check(String s) {
		boolean[] check = new boolean[26];
		int prev = 0;
		for(int i = 0; i < s.length(); i++) {
			int now = s.charAt(i);
			
			if(prev != now) {
				if(check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				}
				else	return false;
			}else	continue;
		}
		
		return true;
	}

}

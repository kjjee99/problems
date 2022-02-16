package silver;

/*
 * A→B
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_16953 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int result = 1;
		
		//B에서 A로
		while(start < end) {
			if(start == end) {
				System.out.println(result);
				return;
			}
			if(end % 10 == 1) {		//B의 끝자리가 '1'로 끝날 때
				end /= 10;
				result++;
			}
			else if(end % 2 == 0){	//2로 나누어질 때
				end /= 2;
				result++;
			}
			else	break;			//아무것도 해당되지 않을 때
		}
		if(start != end)		result = -1;
		System.out.println(result);
	}

}

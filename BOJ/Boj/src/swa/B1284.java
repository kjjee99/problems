package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1284 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());	//A사 요금
			int q = Integer.parseInt(st.nextToken());	//B사 R리터 이하 요금
			int r = Integer.parseInt(st.nextToken());	//R리터
			int s = Integer.parseInt(st.nextToken());	//그 이상 S
			int w = Integer.parseInt(st.nextToken());	//사용한 양
			
			int a = p * w;
			int b = q;
			if(w > r) {
				b += (w - r) * s;
			}
			int result = Math.min(a, b);
			
			System.out.println("#"+testCase+" "+result);
		}
		
	}

}

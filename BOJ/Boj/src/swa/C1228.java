package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C1228 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int len = Integer.parseInt(br.readLine());
			ArrayList<Integer> encoded = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < len; i++) {
				encoded.add(Integer.parseInt(st.nextToken()));
			}
			int amount = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < amount; i++) {
				//I 삽입
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j = 0; j < count; j++) {
					encoded.add(idx + j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+testCase+" ");
			for(int i = 0 ; i < 10; i++) {
				System.out.print(encoded.get(i)+" ");
			}
			System.out.println();
		}
	}

}

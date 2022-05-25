package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C1225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int value = 1;
			while(value > 0) {
				for(int i = 1; i < 6; i++) {
					value = queue.poll();
					value -= i;
					if(value <= 0)	value = 0;
					queue.offer(value);
					if(value == 0) break;
				}
			}
			
			System.out.print("#"+T+" ");
			for(int i = 0; i < 8; i++) {
				System.out.println(queue.poll() + " ");
			}
			System.out.println();
			
			/*
			 * int[] numbers = new int[8]; for(int i = 0 ; i < 8; i++) { numbers[i] =
			 * Integer.parseInt(st.nextToken()); } int idx = 1; while(numbers[7] > 0) {
			 * if(idx > 5) idx = 1; int tmp = numbers[0] - idx;
			 * 
			 * if(tmp < 0) tmp = 0; for(int i = 1; i < 8; i++) { numbers[i - 1] =
			 * numbers[i]; } numbers[7] = tmp; idx++; } System.out.print("#"+T +" ");
			 * for(int num : numbers) { System.out.print(num+" "); }
			 */
		}
	}

}

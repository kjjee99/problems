package silver;

/*
 * ATM 최소 사용시간
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine());		
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int wait[] = new int[people];
		for(int i = 0; i < people; i++) {
			wait[i] = Integer.parseInt(st.nextToken());
		}
		
		wait = sort(wait);
		
		for(int i = 0; i < people; i++) {
			result += wait[i] * (people - i);
		}
		
		System.out.println(result);
		
	}
	
	public static int[] sort(int arr[]) {
		//selection
		int least, temp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			least = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[least] > arr[j])		least = j;
			}
			
			if(i != least) {
				temp = arr[i];
				arr[i] = arr[least];
				arr[least] = temp;
			}
		}
		return arr;
		
		/*
		 * 입력받는 시기에 넣어야함.
		 * Counting Sort
		 * https://st-lab.tistory.com/104
		 * 
		 * while(people-- > 0){
		 * wait[Intger.parseInt(st.nextToken())]++;
		 */
	}

}

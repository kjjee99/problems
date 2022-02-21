package silver;

/*
 * 배열 안에 있는 수 찾기_binary search
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
	static int arr[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	private static int binarySearch(int key) {
		int lo = 0;					//end of left
		int hi = arr.length - 1;	//end of right
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			//key값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			//key값이 중간 위치의 값보다 클 경우
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			//key값이 중간 위치의 값과 같은 경우
			else {
				return mid;
			}
		}
		//not exist
		return -1;
	}

}
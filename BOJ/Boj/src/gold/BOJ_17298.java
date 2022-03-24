package gold;

/*
 * 수열의 오큰수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
//		int[] result = new int[N];
//		Arrays.fill(result, -1);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Stack<Integer> stack = new Stack<>();
//		int index = 0;

		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
				arr[stack.pop()] = arr[i];
			stack.push(i);
		}
		while(!stack.isEmpty())
			arr[stack.pop()] = -1;
		
		/*
		 * 메모리 초과
		while (index < N) {
			for (int i = index; i < N; i++) {
				stack.push(arr[i]);
				int last = stack.peek();
				if (arr[index] < last) {
					result[index] = last;
					break;
				}
			}
			
			index++;
		}*/
		
		StringBuilder sb = new StringBuilder();
//		for(int res : result) {
		for(int res : arr) {
			sb.append(res).append(' ');
			
		}
		System.out.println(sb);
	}

}

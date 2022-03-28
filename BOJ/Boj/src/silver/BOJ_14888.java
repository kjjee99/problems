package silver;

/*
 * 연산자 끼워넣기
 * 백트래킹
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static int addition, subtraction, multi, division;
	private static int[] numbers;
	private static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		addition = Integer.parseInt(st.nextToken());
		subtraction = Integer.parseInt(st.nextToken());
		multi = Integer.parseInt(st.nextToken());
		division = Integer.parseInt(st.nextToken());
		
		calculate(0, numbers[0]);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	private static void calculate(int n, int result) {
		if(n == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		int cal = result;
		if(addition > 0) {
			result += numbers[n + 1];
			addition--;
			calculate(n + 1, result);
			addition++;
		}
		result = cal;
		if(subtraction > 0) {
			result -= numbers[n + 1];
			subtraction--;
			calculate(n + 1, result);
			subtraction++;
		}
		result = cal;
		if(multi > 0) {
			result *= numbers[n + 1];
			multi--;
			calculate(n + 1, result);
			multi++;
		}
		result = cal;
		if(division > 0) {
			result /= numbers[n + 1];
			division--;
			calculate(n + 1, result);
			division++;
		}
		
		/*
		 * for(int i = 0; i < 4; i++){
		 * if(operator[i] > 0){
		 * operator[i]--;
		 * 
		 * switch(i){
		 * case 0: dfs(n + 1,result + numbers[n + 1]); break;
		 * case 1: dfs(n + 1,result - numbers[n + 1]); break;
		 * case 2: dfs(n + 1,result * numbers[n + 1]); break;
		 * case 3: dfs(n + 1,result / numbers[n + 1]); break;
		 * 
		 * operator[i]++;
		 */
	}

}

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	private static int trees[];
	private static int min, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(max < trees[i])	max = trees[i];
		}
		System.out.println(binarySearch(M));
	}
	
	private static int binarySearch(int key) {
		while(min < max) {
			int mid = (min + max) / 2;
			//long으로 하지 않으면 범위를  커버할 수 없음.
			long sum = 0;
			
			for(int tree : trees) {
				if(mid < tree)	sum += tree - mid;
			}
			
			if(sum < key) 	max = mid;
			else			min = mid + 1;
			
		}
		/*
		 * 탐색을 끝낸 min의 값이 원하는 값의 + 1 한 값이기 때문에 -1을 해주어야 함.
		 */
		return (min - 1);
	}

}

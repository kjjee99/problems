package silver;

/*
 * 통계학
 * 정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BOJ_2108 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		for(int num : arr) {
			//getOrDefault()는 hashmap에 존재하지 않으면 default값 반환
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int numbers = 0;
		for(int key : map.values()) {
			numbers = Math.max(numbers, key);
		}
		for(int key: map.keySet()) {
			if(map.get(key) == numbers)
				list.add(key);
		}
		Collections.sort(list);
		
		System.out.println(Math.round((float)sum / N));		//산술평균
		System.out.println(arr[N/2]);						//중앙값
		//최빈값
		if(list.size() >= 2)	System.out.println(list.get(1));
		else					System.out.println(list.get(0));
		System.out.println(arr[N - 1] - arr[0]);			//범위
	}

}

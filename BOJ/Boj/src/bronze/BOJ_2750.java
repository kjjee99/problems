package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int[] list = new int[number];
		for(int i = 0; i < number; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		selection(list);
		
		for(int i = 0; i < number; i++) {
			System.out.println(list[i]);
		}
	}
	
	//selection sort
	public static void selection(int[] list) {
		for(int i = 0; i < list.length; i++) {
			for(int j = i + 1; j < list.length; j++) {
				if(list[i] > list[j]) {
					int temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}
	
	//bubble sort: 인접한 두 개의 원소 비교
	public static void bubble(int[] list) {
		for(int i = list.length; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(list[j] > list[j+1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}
	
	//insert sort: 정렬된 집합에 추가된 원소의 자리를 찾아주며 비교
	public static void insertion(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int temp = list[i];
			int j = i;
			while(j > 0 && list[j - 1] > temp) {
				list[j] = list[j - 1];
				j--;
			}
			list[j] = temp;
		}
	}
	
	//quick sort: pivot 이용해 맨앞과 맨뒤에서 비교
	public static void quick(int[] list) {
		if(list.length == 1) return;		//원소가 1개인 경우 종료
		
		int end = list.length;
		int pivot = 0;
		int left = pivot + 1;
		int right = end -1;
		
		while(left <= right) {
			//pivot > ?
			while(left <= end && list[left] <= list[pivot]) left += 1;
			
			//pivot < ?
			while(right > 0 && list[right] >= list[pivot]) right -= 1;
			
			//엇갈렸을 때
			if(left > right) {
				int temp = list[right];
				list[right] = list[pivot];
				list[pivot] = temp;
			}else {
				int temp = list[right];
				list[right] = list[left];
				list[left] = temp;
			}
		}
	}
	
	//count sort: 데이터의 최대 - 최소 < 1,000,000이고 정수 형태로 표현할 수 있을 때 사용가능
	public static void count(int[] list) {
		int[] c = new int[list.length];
		for(int i = 0; i < c.length; i++)
			c[list[i]] += 1;				//각 데이터에 해당하는 인텍스의 값 증가
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i]; j++)
				System.out.println(i);		//동작한 횟수만큼 인덱스 출력
		}
	}
}

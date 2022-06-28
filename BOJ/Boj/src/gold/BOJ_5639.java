package gold;

/*
 * 이진 검색 트리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_5639 {
	private static ArrayList<Integer> tree = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String input = br.readLine();
			// 빈 값이 들어올 때 입력 종료
			if(input == null || input.equals(""))	break;
			tree.add(Integer.parseInt(input));
		}
		postorder(0, tree.size() - 1);
	}
	
	// 분할 정복
	private static void postorder(int start, int end) {
		if(start > end)	return;
		
		int mid = start + 1;
		
		// 리프노드 찾기
		// 범위에서 벗어나지 않고, 값이 작을 때
		while(mid <= end && tree.get(mid) < tree.get(start))	mid++;
		
		// 왼쪽 트리
		postorder(start + 1, mid - 1);
		// 오른쪽 트리
		postorder(mid, end);
		// 후위순회에서는 마지막 노드가 루트 노드
		System.out.println(tree.get(start));
	}

}

package gold;

/*
 * 트리의 순회
 * 중위, 후위 순회를 주고 전위로 바꾸기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2263 {
	private static int[] inorder;
	private static int[] postorder;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 중위순회
		inorder = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		// 후위순회
		postorder = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		getPreorder(1, n, 1, n);
		System.out.println(sb);

	}

	private static void getPreorder(int in_start, int in_end, int post_start, int post_end) {
		// in_start = inorder의 시작 위치
		// in_end = inorder의 끝 위치
		// post_start = postorder의 시작 위치
		// post_end = postorder의 끝 위치

		if (in_start > in_end || post_start > post_end)	return;
		
		// 후위 순회의 가장 오른쪽 = 루트 노드
		int root = postorder[post_end];
		sb.append(root+" ");

		// 루트 노드의 위치 찾기
		// 중위 순회와 후위 순회가 같은 순간은 부모 노드
		int rootIndex = in_start;
		for(int i = in_start; i <= in_end; i++) {
			if(inorder[i] == root) {
				rootIndex = i;
				break;
			}
		}
		// 루트 기준 왼쪽 노드 개수
		int leftCnt = rootIndex - in_start;

		// 분할 정복
		// 왼쪽 자식 트리
		getPreorder(in_start, rootIndex - 1, post_start, post_start + leftCnt - 1);
		// 오른쪽 자식 트리
		getPreorder(rootIndex + 1, in_end, post_start + leftCnt, post_end - 1);
	}

}

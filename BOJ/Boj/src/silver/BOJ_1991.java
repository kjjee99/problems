package silver;

/*
 * 트리의 순회
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1991 {
	
	public static class Node{
		// 왼쪽 자식
		public int left;
		// 오른쪽 자식
		public int right;
		
		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	// 노드를 타입으로 가지는 연결리스트 생성
	private static ArrayList<Node>[] list;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		
		// initialize
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			String[] token = br.readLine().split(" ");
			// A = 1, ... , Z = 26
			int parent = token[0].charAt(0) - 'A' + 1;
			int left = token[1].charAt(0) - 'A' + 1;
			int right = token[2].charAt(0) - 'A' + 1;
			
			list[parent].add(new Node(left, right));
		}
		
		preorder(1);
		sb.append('\n');
		inorder(1);
		sb.append('\n');
		postorder(1);
		
		System.out.println(sb);
	}
	
	// 전위
	private static void preorder(int start) {
		for(Node node : list[start]){
			int left = node.left;
			int right = node.right;
			
			// casting
			sb.append((char)(start+'A' - 1));
			// '.' - 'A' + 1 = -18
			if(left != -18) preorder(left);
			if(right != -18) preorder(right);
			
		}
	}
	
	// 중위
	private static void inorder(int start) {
		for(Node node : list[start]){
			int left = node.left;
			int right = node.right;
			
			if(left != -18) inorder(left);
			sb.append((char)(start+'A' - 1));
			if(right != -18) inorder(right);
			
		}
	}
	
	// 후위
	private static void postorder(int start) {
		for(Node node : list[start]){
			int left = node.left;
			int right = node.right;
			
			if(left != -18) postorder(left);
			if(right != -18) postorder(right);
			sb.append((char)(start+'A' - 1));
			
		}
	}

}

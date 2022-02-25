package silver;

/*
 * 단지 번호 붙이기
 * BFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
	private static int arr[][] = new int[25][25];				//지도
	private static int aparts[] = new int[25*25];				//각 단지의 아파트 수
	private static boolean visited[][] = new boolean[25][25];	//방문 전적
	private static int apartNum = 0;							//apart 단지 번호 수
	private static int N;										//지도 크기
	
	private static int dx[] = {-1, 1, 0, 0};					//상하
	private static int dy[] = {0, 0, -1, 1};					//좌우
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = st.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				if(arr[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					bfs(i, j);
				}
					
		}
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		for(int apart : aparts)	
			if(apart > 0)
				System.out.println(apart);
		
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		visited[x][y] = true;
		aparts[apartNum]++;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < N && nextY < N && nextX >= 0 && nextY >= 0) {
					if(arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						queue.add(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						aparts[apartNum]++;
					}
				}
			}
		}
	}

}

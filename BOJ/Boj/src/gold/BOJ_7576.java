package gold;

/*
 * 토마토 한판
 * bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	private static int[][] tomato;
	private static int N, M;
	private static Queue<int[]> q = new LinkedList<>();
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1)	q.add(new int[] {i, j});
			}
		}
		
		System.out.println(mature());
	}
	
	private static int mature() {
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)	continue;
				if(tomato[nextX][nextY] == 0) {
					q.add(new int[] {nextX, nextY});
					tomato[nextX][nextY] = tomato[nowX][nowY] + 1;
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) return -1;
				result = Math.max(result, tomato[i][j]);
			}
		}
		if(result == 1)	return 0;
		else			return result - 1;
		
		
	}

}

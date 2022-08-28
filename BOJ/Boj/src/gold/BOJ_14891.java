package gold;

/*
 * 톱니바퀴
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14891 {
	private static int[][] map;
	private static int[] direction;
	private static int[] dx = {-1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String input = br.readLine();
			for(int j = 0; j < 8; j++) {
				// 0 = N , 1 = S
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			// 1 = 시계 방향, -1 = 반시계 방향
			int dir = Integer.parseInt(st.nextToken());
			check(no - 1, dir);
			rotate(no - 1, dir);
		}
		
		// 1 2 4 8
		int total = 0;
		for(int i = 0; i < 4; i++) {
			if(map[i][0] == 1)	total += Math.pow(2, i);
		}
		System.out.println(total);
	}
	
	private static void rotate(int no, int dir) {
		for(int j = 0; j < 4; j++)
		{
		if(direction[j] == 0)	continue;
		// 시계 방향
		if(direction[j] == 1) {
			int temp = map[j][7];
			for(int i = 7; i > 0; i--) {
				map[j][i] = map[j][i - 1];
			}
			map[j][0] = temp;
		}
		// 반시계 방향
		else {
			int temp = map[j][0];
			for(int i = 0; i < 7; i++) {
				map[j][i] = map[j][i + 1];
			}
			map[j][7] = temp;
		}
		}
	}
	
	// 회전 방향 세팅
	private static void check(int no, int dir) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {no, dir});
		
		direction = new int[4];
		direction[no] = dir;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 2; i++) {
				int nx = now[0] + dx[i];
				
				// 범위 확인
				if(nx < 0 || nx > 3)	continue;
				// 방문한 노드 확인
				if(direction[nx] != 0)	continue;
				
				// 같지 않을 때 회전
				// left
				if(dx[i] == -1) {
					if(map[nx][2] != map[now[0]][6]) {
						q.add(new int[] {nx, now[1] * -1});
						// 회전 방향의 반대
						direction[nx] = now[1] * -1;
					}
				}
				// right
				else {
					if(map[nx][6] != map[now[0]][2]) {
						q.add(new int[] {nx, now[1] * -1});
						// 회전 방향의 반대
						direction[nx] = now[1] * -1;
					}
				}
			}
		}
	}

}



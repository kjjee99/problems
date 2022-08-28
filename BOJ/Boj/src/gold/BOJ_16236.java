package gold;

/*
 * 아기 상어
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	private static int[][] map;
	// 상 좌 하 우
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, -1, 0, 1};
	private static int N, time = 0, cnt = 0, sharkSize = 2;
	private static int row, col;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 크기
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 9일 때 아기 상어의 위치
				if(map[i][j] == 9)	{
					row = i;
					col = j;
					// 크기로 판단하기 위함
					map[i][j] = 0;
				}
			}
		}
		
		bfs();
		System.out.println(time);
	}
	
	private static void bfs() {
		// 아기 상어가 잡아먹을 수 있을 때까지 반복
		while(true) {
			// 잡아먹은 수가 아기 상어의 크기와 같을 때
			if(cnt == sharkSize) {
				cnt = 0;
				sharkSize++;
			}
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {row, col, 0});
			
			boolean[][] visited = new boolean[N][N];
			
			int minRow = Integer.MAX_VALUE;
			int minCol = Integer.MAX_VALUE;
			int minTime = Integer.MAX_VALUE;
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				visited[now[0]][now[1]] = true;
				// 최소 시간으로 물고기를 먹을 수 있는 시간을 넘으면 종료
				if(now[2] >= minTime)	break;
				
				for(int i = 0; i < 4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					
					// 범위를 벗어날 때
					if(nx < 0 || nx >= N || ny < 0 || ny >= N)	continue;
					// 방문한 칸이거나 아기 상어의 크기보다 클 때
					if(visited[nx][ny] || map[nx][ny] > sharkSize)	continue;
					
					if(map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
						// 제일 위쪽 칸
						if(nx < minRow) {
							minRow = nx;
							minCol = ny;
							minTime = now[2] + 1;
						}
						// 제일 왼쪽 칸
						else if(nx == minRow && ny < minCol) {
							minCol = ny;
							minTime = now[2] + 1;
						}
					}
					
					q.add(new int[] {nx, ny, now[2] + 1});
					visited[nx][ny] = true;
				}
	 		}
			
			// 잡아먹을 물고기가 없을 때
			if(minTime == Integer.MAX_VALUE) return;
			
			time += minTime;
			cnt++;
			row = minRow;
			col = minCol;
			q.add(new int[] {minRow, minCol, 0});
			map[row][col] = 0;
		
		}
		
	}

}

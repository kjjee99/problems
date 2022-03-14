package silver;

/*
 * 나이트 옮기기
 * bfs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
	private static int N; // 체스판 크기
	private static int[] start = new int[2];
	private static int[] finish = new int[2];
	private static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	private static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			finish[0] = Integer.parseInt(st.nextToken());
			finish[1] = Integer.parseInt(st.nextToken());

			bfs(start[0], start[1]);
			System.out.println(map[finish[0]][finish[1]]);
		}
	}

	private static void bfs(int start_x, int start_y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start_x, start_y });
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			if (nowX == finish[0] && nowY == finish[1])			return;
			for (int i = 0; i < 8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)	continue;
				if (map[nextX][nextY] == 0) {
					map[nextX][nextY] = map[nowX][nowY] + 1;
					q.add(new int[] { nextX, nextY });
				}
			}
		}
	}
}

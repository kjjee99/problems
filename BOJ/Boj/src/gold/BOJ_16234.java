package gold;
/*
 * 인구 이동
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	private static ArrayList<int[]> list;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int n, l, r, total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 크기
		n = Integer.parseInt(st.nextToken());
		// L명 이상, R명 이하
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			boolean flag = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						if (list.size() > 1) {
							int size = total / list.size();
							for (int[] co : list) {
								map[co[0]][co[1]] = size;
							}
							flag = true;
						}

					}
				}
			}
			if(!flag)	break;
			
			cnt++;
		}

		System.out.println(cnt);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		list = new ArrayList<>();
		visited[x][y] = true;
		total = map[x][y];
		list.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int population = map[now[0]][now[1]];

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				// 범위를 벗어났을 때
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)	continue;
				// 방문했을 때
				if (visited[nx][ny])	continue;

				int diff = Math.abs(population - map[nx][ny]);

				// 차이가 범위안에 있을 때
				if (diff >= l && diff <= r) {
					total += map[nx][ny];
					list.add(new int[] { nx, ny });
					q.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}

	}

}

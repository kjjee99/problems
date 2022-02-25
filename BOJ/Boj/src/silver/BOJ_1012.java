package silver;

/*
 * 양배추 기르기
 * 벌레를 몇 마리를 풀어야 할까?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	private static int graph[][]; // 지도
	private static boolean visited[][]; // 방문 전적
	private static int N, M; // 지도 크기

	private static int dx[] = { -1, 1, 0, 0 }; // 상하
	private static int dy[] = { 0, 0, -1, 1 }; // 좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int count = 0;
			
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 위치 개수
			
			graph = new int[M][N];
			visited = new boolean[M][N];
			
			// input
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}

			// calculate
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++)
					if (graph[i][j] == 1 && !visited[i][j]) {
						count++;
						bfs(i, j);
					}
			}
			System.out.println(count);
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < M && nextY < N && nextX >= 0 && nextY >= 0) {
					if (graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						queue.add(new int[] { nextX, nextY });
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}

}

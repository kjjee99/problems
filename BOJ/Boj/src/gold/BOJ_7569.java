package gold;

/*
 * 토마토 여러 판
 * bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	private static Queue<int[]> q = new LinkedList<>();
	private static int[][][] tomato;
	private static int[] dx = {0, 0, 0, 0, 1, -1};
	private static int[] dy = {0, 0, 1, -1, 0, 0};
	private static int[] dz = {1, -1, 0, 0, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 1)	q.add(new int[] {i, j, k});
				}
			}
		}
		
		System.out.println(bfs(H, N, M));
		
	}
	
	private static int bfs(int H, int N, int M) {
		int result = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int h = now[0];
			int x = now[1];
			int y = now[2];
			
			for(int i = 0; i < 6; i++) {
				int nextH = h + dz[i];
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if(nextH < 0 || nextX < 0 || nextY < 0 || nextH >= H || nextX >= N || nextY >= M)	continue;
				if(tomato[nextH][nextX][nextY] == 0) {
					q.add(new int[] {nextH, nextX, nextY});
					tomato[nextH][nextX][nextY] = tomato[h][x][y] + 1;
				}
			}
		}
		
		for(int i = 0;  i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(tomato[i][j][k] == 0)	return -1;
					result  = Math.max(result, tomato[i][j][k]);
				}
			}
		}
		if(result == 1)		return 0;
		else				return result - 1;
	}

}

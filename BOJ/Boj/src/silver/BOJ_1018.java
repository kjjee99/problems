package silver;

/*
 * 체스판 색칠하기
 * 브루트포스
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	private static int cnt = 64;
	private static boolean[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//체스판 크기
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j< M; j++) {
				if(s.charAt(j) == 'W')
					map[i][j] = true;
				else
					map[i][j] = false;
			}
		}
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M -8; j++) {
				chess(i, j);
			}
		}
		System.out.println(cnt);
		
	}
	
	private static void chess(int row_start, int col_start) {
		boolean now = map[row_start][col_start];
		int nowCnt = 0;
		for(int i = row_start; i < row_start + 8; i++) {
			for(int j = col_start; j < col_start + 8; j++) {
				if(map[i][j] != now)	nowCnt++;
				now = !now;
			}
			now = !now;
		}
		
		nowCnt = Math.min(nowCnt, (64 - nowCnt));
		cnt = Math.min(cnt, nowCnt);
	}

}

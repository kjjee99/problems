package swa;

/* 홈 방범 서비스 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_2117 {
    private static int n, m, max;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 도시의 크기
            m = Integer.parseInt(st.nextToken());   // 집이 지불할 수 있는 비용

            map = new int[n][n];    // 1: 집
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    bfs(i, j);
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void bfs(int x, int y){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        visited[x][y] = true;

        int cnt = 1;
        int house = map[x][y] == 1 ? 1 : 0;
        while(!q.isEmpty()){
            int cost = cnt * cnt + (cnt - 1) * (cnt - 1);
            if(house * m - cost >= 0)    max = Math.max(max, house);

            int size = q.size();
            cnt++;

            for(int k = 0; k < size; k++) {
                int[] now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visited[nx][ny]) continue;

                    if (map[nx][ny] == 1) house++;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }


        }


    }
}

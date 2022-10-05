package gold;

/*
치즈
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int cnt = 0, time = 0;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)  cnt++;
            }
        }
        int res = cnt;
        while(true){
            visited = new boolean[n][m];
            bfs();
            time++;
            if(cnt == 0)    break;
            res = cnt;
        }

        System.out.println(time);
        System.out.println(res);
    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != 0)    {
                    map[nx][ny] = 0;
                    visited[nx][ny] = true;
                    cnt--;
                    continue;
                }

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}

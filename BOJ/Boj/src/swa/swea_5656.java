package swa;
/* 벽돌깨기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> q = new LinkedList<>();
    private static int n, w, h, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            drop(0);

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void drop(int cnt){
        // 다 탐색했을 경우
        if(cnt == n){
            int total = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] != 0)  total++;
                }
            }
            min = Math.min(min, total);
            return;
        }

        for(int i = 0; i < w; i++) {
            int[][] copy = copyMap();
            for(int j = 0; j < h; j++){
                if(map[j][i] > 0)   {
                    destroy(j, i);
                    break;
                }
            }
            blank();
            drop(cnt + 1);
            map = copy;
        }
    }

    private static void print(){
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void destroy(int x, int y){
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int sx = now[0];
            int sy = now[1];
            int dis = map[sx][sy];
            map[sx][sy] = 0;

            if(dis == 1)     continue;
            for (int j = 0; j < 4; j++) {
                for (int i = 1; i < dis; i++) {
                    int nx = sx + dx[j] * i;
                    int ny = sy + dy[j] * i;

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void blank(){
        for(int j = 0; j < w; j++){
            for(int i = h - 1; i > 0; i--){
                if(map[i][j] == 0) {
                    for(int k = i - 1; k > -1; k--) {
                        if(map[k][j] == 0)  continue;
                        map[i][j] = map[k][j];
                        map[k][j] = 0;
                        break;
                    }
                }
            }
        }
    }

    private static int[][] copyMap(){
        int[][] copy = new int[h][w];
        for(int i = 0; i < h; i++){
            copy[i] = Arrays.copyOf(map[i], w);
        }
        return copy;
    }
}

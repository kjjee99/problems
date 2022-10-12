package swa;

/* 등산로 조성 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1949 {
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<int[]> maximum;
    private static int n, k, res;

    private static class Mountain{
        int x, y, cnt, depth;
        public Mountain(int x, int y, int cnt, int depth){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 크기
            k = Integer.parseInt(st.nextToken());   // 공사 깊이

            map = new int[n][n];
            int max = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            maximum = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == max)    maximum.add(new int[] {i, j});
                }
            }

            res = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int x = 1; x <= k; x++){
                        map[i][j] -= x;
//                        print();
                        for(int[] now : maximum){
                            if(map[now[0]][now[1]] != max)  continue;
                            res = Math.max(res, move(now[0], now[1]));
                        }
                        map[i][j] += x;
                    }
                }
            }
            System.out.println("#"+tc+" " + res);
        }
    }

    private static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int move(int x, int y){
        Queue<Mountain> q = new LinkedList<>();
        q.add(new Mountain(x, y, 1, map[x][y]));

        int cnt = 0;
        while(!q.isEmpty()) {
            Mountain m = q.poll();

            cnt = Math.max(cnt, m.cnt);
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] >= m.depth) continue;

                q.add(new Mountain(nx, ny, m.cnt + 1, map[nx][ny]));
            }
        }
        return cnt;
    }
}

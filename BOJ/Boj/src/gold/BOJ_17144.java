package gold;

/* 미세먼지 안녕! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17144 {
    private static int[][] map;
    private static List<int[]> aircleaner = new ArrayList<>();
    private static int[] dx = {-1, 0, 1, 0};    // 상 우 하 좌
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<int[]> q = new LinkedList<>();
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        int idx = 0;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) aircleaner.add(new int[] {i, j});
                if(map[i][j] > 0)   q.add(new int[] {i, j});
            }
        }

        while(t-- > 0){
            dust();
            q.clear();
            clean();

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(map[i][j] > 0)   q.add(new int[] {i, j});
                }
            }
//            print();
        }

        int total = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] > 0)   total += map[i][j];
            }
        }
        System.out.println(total);
    }

    private static void print(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dust(){
        int[][] tmp = new int[r][c];
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            int cnt = 0;    // 확산된 개수
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c)  continue;
                if(map[nx][ny] == -1)   continue;

                tmp[nx][ny] += map[x][y] / 5;
                cnt++;
            }

            tmp[x][y] += map[x][y] - (map[x][y] / 5) * cnt;
        }

        for(int i = 0; i < 2; i++){
            int[] air = aircleaner.get(i);
            tmp[air[0]][air[1]] = -1;
        }

        map = tmp;
    }

    private static void clean(){
        int[] start = aircleaner.get(0);
        int dir = 0;
        int x = start[0];
        int y = start[1];

        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx == start[0] && ny == start[1])    {
                map[x][y] = 0;
                break;
            }

            if(nx < 0 || ny < 0 || nx > start[0] || ny >= c){
                nx -= dx[dir];
                ny -= dy[dir];
                dir++;
                nx += dx[dir];
                ny += dy[dir];
            }

            if(map[x][y] != -1) map[x][y] = map[nx][ny];
            x = nx; y = ny;
        }

        start = aircleaner.get(1);
        dir = 3;
        x = start[0];
        y = start[1];

        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx == start[0] && ny == start[1])    {
                map[x][y] = 0;
                break;
            }

            if(nx < start[0] || ny < 0 || nx >= r || ny >= c){
                nx -= dx[dir];
                ny -= dy[dir];
                dir = (dir + 3) % 4;
                nx += dx[dir];
                ny += dy[dir];
            }
            if(map[x][y] != -1) map[x][y] = map[nx][ny];
            x = nx; y = ny;
        }
    }
}

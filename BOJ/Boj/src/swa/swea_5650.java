package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5650 {
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};    // 상 우 하 좌
    private static int[] dy = {0, 1, 0, -1};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    if(map[i][j] != 0)  continue;
                    for(int d = 0; d < 4; d++){
                        int cnt = pinball(i, j, d);
//                        System.out.println(cnt);
                        max = Math.max(max, cnt);
                    }
                }
            }
            System.out.println("#"+ tc+ " " + max);
        }
    }

    private static int pinball(int x, int y, int d){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, d});

        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int dir = now[2];

            int block = map[now[0]][now[1]];
            if(block > 0 && block < 6){     // 블록을 만났을 경우
                dir = changeDir(block, dir);
                cnt++;
            }

            int nx = now[0] + dx[dir];
            int ny = now[1] + dy[dir];

            // 범위를 벗어났을 때
            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                nx = now[0];
                ny = now[1];
                dir = (dir + 2) % 4;
                cnt++;
            }

            if(nx == x && ny == y)  break;         // 출발 위치로 돌아오면 종료
            if(map[nx][ny] == -1) break;          // 블랙홀을 만났을 경우 게임 종료
            if(map[nx][ny] > 5){                  // 웜홀을 만났을 경우
                boolean flag = false;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(map[i][j] == map[nx][ny]){
                            if(i == nx && j == ny)  continue;
                            nx = i; ny = j;
                            flag = true;
                            break;
                        }
                    }
                    if(flag)    break;
                }
            }
            q.add(new int[] {nx, ny, dir});
        }
        return cnt;
    }

    private static int changeDir(int block, int dir){
        switch (block){
            case 1:
                if(dir == 2)        dir = 1;
                else if(dir == 3)   dir = 0;
                else                dir = (dir + 2) % 4;
                break;
            case 2:
                if(dir == 0)        dir = 1;
                else if(dir == 3)   dir = 2;
                else                dir = (dir + 2) % 4;
                break;
            case 3:
                if(dir == 0)        dir = 3;
                else if(dir == 1)   dir = 2;
                else                dir = (dir + 2) % 4;
                break;
            case 4:
                if(dir == 2)        dir = 3;
                else if(dir == 1)   dir = 0;
                else                dir = (dir + 2) % 4;
                break;
            case 5:
                dir = (dir + 2) % 4;
                break;

        }
        return dir;
    }
}

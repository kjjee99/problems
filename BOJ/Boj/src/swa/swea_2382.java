package swa;

/* 미생물 격리 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_2382 {
    private static class Microbe{
        public int x, y, cnt, dir;  // 세로 위치, 가로 위치, 미생물의 수, 이동 방향

        public Microbe(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    private static int n, m, k;
    private static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static List<Microbe> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 셀의 개수
            m = Integer.parseInt(st.nextToken());   // 격리기간
            k = Integer.parseInt(st.nextToken());   // 미생물 군집의 개수

            list = new ArrayList<>();

            map = new int[n][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;

                list.add(new Microbe(x, y, c, d));
                map[x][y] = c;
            }

//            print();

            // m 시간이 지날 때까지
            while(m-- > 0){
                move();
                Collections.sort(list, new Comparator<Microbe>(){
                    @Override
                    public int compare(Microbe o1, Microbe o2) {
                        int num1 = o1.x * n + o1.y;
                        int num2 = o2.x * n + o2.y;
                        if(num1 == num2){
                            return o2.cnt - o1.cnt;
                        }
                        return num1 - num2;
                    }
                });
                combine();
//                print();
            }

            int total = 0;
            for(int i = 0; i < list.size(); i++){
                total += list.get(i).cnt;
            }

            System.out.println("#"+tc+" "+total);
        }
    }

    private static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 미생물들 움직이기
    private static void move(){
        for(int i = 0; i < list.size(); i++){
            Microbe microbe = list.get(i);

            int x = microbe.x;
            int y = microbe.y;
            int cnt = microbe.cnt;
            int dir = microbe.dir;

            map[x][y] = 0;

            int nx = x + dx[dir];
            int ny = y + dy[dir];


            // 빨간 색이 칠해진 가장자리는 반토막
            if (nx == 0 || ny == 0 || nx == n - 1 || ny == n - 1) {
                cnt /= 2;
                dir = change(dir);
            }
            if (cnt < 1) {
                list.remove(i);
                i--;
                continue;
            }

//            System.out.println(x + " " + y + " " + nx + " " + ny + " " + cnt);
            list.set(i,new Microbe(nx, ny, cnt, dir));
        }
    }

    // 미생물들이 같은 위치에 있으면 합치기
    private static void combine(){
        for(int i = 0; i < list.size(); i++){
            Microbe m = list.get(i);
            int x = m.x;
            int y = m.y;
            int size = m.cnt;

            if(map[x][y] == 0)  map[x][y] = size;
            else {
                for(int j = 0; j < i; j++){
                    Microbe prev = list.get(j);
                    if(prev.x == x && prev.y == y){
                        prev.cnt += size;
                        map[x][y] = prev.cnt;
                        list.remove(i);
                        i--;
                        break;
                    }
                }
//                System.out.println(x + " " + y + " " + map[x][y]);
            }
        }
    }

    private static int change(int dir){
        switch (dir){
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return -1;
    }
}

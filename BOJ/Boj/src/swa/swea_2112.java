package swa;

/* 보호 필름 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2112 {
    private static int d, w, k; // 두께, 가로 길이,검사 기준
    private static int min;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[d][w];    // 0: A, 1: B
            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            change(0,0);
            System.out.println("#"+tc+" " +min);
        }
    }

    private static void change(int start, int cnt){
//        print();
        if(check()) {
//            System.out.println(cnt);
            min = Math.min(min, cnt);
            return;
        }
        if(cnt > min)   return;
        if(start == d)  return;

        change(start + 1, cnt);     // 변하지 않고 다음 행으로

        int[] copy = new int[w];
        for(int i = 0; i < w; i++){
            copy[i] = map[start][i];
        }

        for(int n = 0; n < 2; n++){
            for(int j = 0; j < w; j++){
                map[start][j] = n;
            }
            change(start + 1, cnt + 1);
        }

        for(int i = 0; i< w; i++){
            map[start][i] = copy[i];
        }
    }
    private static void print(){
        for(int i = 0; i < d; i++){
            for(int j = 0; j < w; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(){
        for(int j = 0; j < w; j++){
            boolean flag = false;
            int cnt = 1;
            for(int i = 0; i < d - 1; i++){
                if(map[i][j] != map[i + 1][j])   cnt = 1;
                else    cnt++;
                if(cnt == k)    {
                    flag = true;
                    break;
                }
            }
            if(!flag)   return false;
        }
        return true;
    }
}

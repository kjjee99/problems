package gold;

/* 색종이 붙이기 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17136 {
    private static int[][] map;
    private static int[] counts = {5, 5, 5, 5, 5};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        int total = 0;
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)  total++;
            }
        }

        if(total != 0)  paper(0);
        else            min = 0;

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static void paper(int cnt){
        if(check()){
            min = Math.min(min, cnt);
            return;
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(map[i][j] == 0) continue;
                for(int k = 0; k < 5; k++){
                    if(color(i, j, k + 1) && counts[k] > 0){
                        paint(i, j, k + 1, 0);
                        counts[k]--;
                        paper(cnt + 1);
                        counts[k]++;
                        paint(i, j, k + 1, 1);
                    }
                }
                return;
            }
        }
    }

    private static boolean color(int x, int y, int size){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(i >= 10 || j >= 10)  return false;
                if(map[i][j] == 0)  return false;
            }
        }
        return true;
    }

    private static void paint(int x, int y, int size, int flag){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                map[i][j] = flag;
            }
        }
    }

    private static boolean check(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(map[i][j] != 0)  return false;
            }
        }
        return true;
    }
}

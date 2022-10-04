package gold;

/*
* 스도쿠
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
    private static int[][] map;
    private static List<int[]> list = new ArrayList<>();
    private static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[9][9];
        for(int i = 0; i < 9; i++){
            String input = br.readLine();
            for(int j = 0; j < 9; j++){
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j] == 0)  list.add(new int[] {i, j});
            }
        }

        fill(0);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fill(int idx){
        // 모든 수를 확인했을 경우
        if(idx == list.size()){
            flag = false;
            return;
        }

        if(!flag)   return;

        int x = list.get(idx)[0];
        int y = list.get(idx)[1];

        for(int n = 1; n < 10; n++){
            // 숫자가 안되는 경우
            if(!check(x, y, n)) continue;

            map[x][y] = n;
            fill(idx + 1);
            if(flag) map[x][y] = 0;
        }
    }

    // 사용할 수 있는 수인지 확인
    private static boolean check(int x, int y, int n){
        // x line
        for(int i = 0; i < 9; i++){
            if(map[i][y] == n)  return false;
        }
        // y line
        for(int j = 0; j < 9; j++){
            if(map[x][j] == n)  return false;
        }
        // 3 X 3
        int r = (x / 3) * 3;
        int c = (y / 3) * 3;
        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(map[i][j] == n)  return false;
            }
        }

        return true;
    }
}

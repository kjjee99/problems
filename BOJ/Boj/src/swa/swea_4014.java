package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_4014 {
    private static int[][] map;
    private static boolean[][] ladder;
    private static int n, x, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());   // ladder length

            map = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;
            ladder = new boolean[n][n];
            for(int i = 0; i < n; i++)
                row(i);

            for(int i = 0; i < n; i++){
                Arrays.fill(ladder[i], false);
            }
            for(int i = 0; i < n; i++)
                col(i);

            System.out.println("#"+tc+" "+answer);
        }
    }

    private static void row(int i){
            for(int j = 0; j < n - 1; j++){
                int level = map[j][i];

                if(map[j + 1][i] == level + 1){             // +1인 경우 __|--
                    for(int k = 1; k < x; k++){
                        if(j - k >= 0 && !ladder[j - k][i] && level == map[j - k][i]) {        // 경사로 길이보다 짧을 때
                            ladder[j - k][i] = true;
                        }
                        else   return;
                    }
                }

                else if(map[j + 1][i] == level - 1){        // -1인 경우 --|__
                    for(int k = 1; k <= x; k++){
                        if(j + k < n && !ladder[j + k][i] && level - 1 == map[j + k][i]){         // 경사로 길이보다 짧을 때
                            ladder[j + k][i] = true;
                        }
                        else return;
                    }
                }
                else if(Math.abs(map[j + 1][i] - level) > 1)    return;

            }
        answer++;

    }

    private static void col(int i){
            for(int j = 0; j < n - 1; j++){
                int level = map[i][j];

                if(map[i][j + 1] == level + 1){             // +1인 경우 __|--
                    for(int k = 1; k < x; k++){
                        if(j - k >= 0 && !ladder[i][j - k] && level == map[i][j - k]) {        // 경사로 길이보다 짧을 때
                            ladder[i][j - k] = true;
                        }
                        else   return;
                    }
                }
                else if(map[i][j + 1] == level - 1){        // -1인 경우 --|__
                    for(int k = 1; k <= x; k++){
                        if(j + k < n && !ladder[i][j + k] && level - 1 == map[i][j + k]) {        // 경사로 길이보다 짧을 때

                            ladder[i][j + k] = true;
                        }
                        else return;
                    }
                }
                else if(Math.abs(map[i][j + 1] - level) > 1)    return;

            }
            answer++;
    }
}

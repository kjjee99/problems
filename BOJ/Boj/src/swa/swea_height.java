package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_height {
    private static boolean distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());    // 학생들의 수
            int m = Integer.parseInt(br.readLine());    // 비교횟수

            distance = new boolean[n + 1][n + 1];
            for(int i = 0; i < m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                distance[a][b] = true;
            }

            int answer = 0;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    for(int k = 1; k <= n; k++){
                        if(distance[i][k] && distance[k][j]){
                            distance[i][j] = true;
                        }
                    }
                }
            }

            int[] cnt = new int[n + 1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(distance[i][j] || distance[j][i])
                        cnt[i]++;
                }
            }

            for(int res : cnt){
                if(res == n - 1)    answer++;
            }

            System.out.println("#"+tc+" "+answer);
        }
    }

}

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191#
 *
 * game의 승패의 개수가 n-1(자신 제외)일 때만 순위를 정할 수 있음
 */
import java.util.*;

class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

        // graph[a][b]
        // a : 이긴 선수, b : 진 선수
        for(int[] result : results){
            graph[result[0]][result[1]] = 1;
        }

        // 4 -> 3 -> 2
        for(int x = 1; x <= n; x++){
            for(int y = 1; y <= n; y++){
                for(int z = 1; z <= n; z++){
                    if(graph[y][x] == 1 && graph[x][z] == 1)
                        graph[y][z] = 1;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int game = 0;
            // i 선수의 승패 개수 확인
            for(int j = 1; j <= n; j++){
                if(graph[i][j] == 1 || graph[j][i] == 1)    game++;
            }

            if(game == n - 1) answer++;
        }
        return answer;
    }
}
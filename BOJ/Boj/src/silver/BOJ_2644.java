package silver;

/**
 * 2644 촌수계산
 * BFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    private static int[][] relationship;
    private static boolean[][] visited;
    private static int result = -1, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람의 수
        n = Integer.parseInt(br.readLine());
        relationship = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        // 촌수를 계산해야하는 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 부모 자식들 간의 관계의 개수
        int m = Integer.parseInt(br.readLine());

        // 부모 자식 간의 관계
        // x = y의 부모
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relationship[x][y] = relationship[y][x] = 1;
        }
        
        bfs(a, b);
        System.out.println(result);
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            if(now[0] == y){    // 도착점에 도달했을 때
                result = now[1];
                break;
            }

            for(int i = 0; i <= n; i++){
                if(!visited[now[0]][i] && relationship[now[0]][i] == 1){
                    queue.add(new int[]{i, now[1] + 1});
                    visited[now[0]][i] = true;
                }
            }
        }
    }
}

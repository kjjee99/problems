package silver;

/**
 * 5014 스타트링크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    private static int result = Integer.MAX_VALUE, F, G, U, D;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());    // 건물의 총 층수
        int S = Integer.parseInt(st.nextToken());    // 현재 위치
        G = Integer.parseInt(st.nextToken());    // 스타트링크 위치
        U = Integer.parseInt(st.nextToken());    // 위
        D = Integer.parseInt(st.nextToken());    // 아래

        visited = new int[F + 1];

        bfs(S, G);
    }

    private static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            if(end == now){  // 원하던 층에 도착했을 때
                System.out.println(visited[now] - 1);
                return;
            }

            // 범위를 벗어났을 때
            if(now + U <= F && visited[now + U] == 0) {
                q.add(now + U);
                visited[now + U] = visited[now] + 1;
            }
            if(now - D >= 1 && visited[now - D] == 0) {
                q.add(now - D);
                visited[now - D] = visited[now] + 1;
            }
        }

        System.out.println("use the stairs");
    }
}

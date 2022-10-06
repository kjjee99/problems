package silver;

/*
맥주 마시면서 걸어가기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9205 {
    private static List<int[]> conv = new ArrayList<>();
    private static int[] house = new int[2];
    private static int[] festival = new int[2];
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            conv.clear();
            n = Integer.parseInt(br.readLine());    // 편의점 개수

            StringTokenizer st = new StringTokenizer(br.readLine());
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                conv.add(new int[] {x, y});
            }

            st = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            if(bfs())   System.out.println("happy");
            else        System.out.println("sad");
        }
    }

    private static boolean bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(house);
        boolean[] visited = new boolean[n];

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            if(Math.abs(cx - festival[0]) + Math.abs(cy - festival[1]) <= 1000) return true;

            for(int i = 0; i < n; i++){
                if(visited[i])  continue;
                int nx = conv.get(i)[0];
                int ny = conv.get(i)[1];

                if(Math.abs(nx - cx) + Math.abs(ny - cy) <= 1000){
                    q.add(new int[] {nx, ny});
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}

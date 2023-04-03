package gold;

/**
 * 컵라면
 * 그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 마감일은 적고, 컵라면은 많은 순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 내림차순
            if(o1[0] == o2[0])  return o2[1] - o1[1];
            // 오름차순
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new int[] {x, y});
        }

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int size = q.size();
            // 마감일이 지난 경우
            if(size < now[0]){
                q.add(now[1]);
            }
            // 마감일이 같은 경우
            else if(size == now[0]){
                int prev = q.peek();
                // 컵라면이 더 많은 경우
                if(now[1] > prev){
                    q.poll();
                    q.add(now[1]);
                }
            }
        }

        int ramen = 0;
        while(!q.isEmpty()){
            ramen += q.poll();
        }
        System.out.println(ramen);
    }
}

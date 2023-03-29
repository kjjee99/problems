package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 흙길 보수하기
 */

public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])  return o1[1] - o1[2];
            return o1[0] - o2[0];
        });
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[] {start, end});
        }

        int pan = 0;
        int range = 0;
        for(int i = 0; i < n; i++){
            int[] now = pq.poll();
            if(now[0] > range){
                range = now[0];
            }
            if(now[1] > range){
                while(now[1] > range){
                    range += l;
                    pan++;
                }
            }
        }

        System.out.println(pan);
    }
}

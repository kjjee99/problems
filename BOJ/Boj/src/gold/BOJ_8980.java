package gold;

/**
 * 택배
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_8980 {
    static class Box implements Comparable<Box>{
        int from, to, count;
        public Box(int from, int to, int count){
            this.from = from;
            this.to = to;
            this.count = count;
        }
        @Override
        public int compareTo(Box box){
            // 보내는 -> 받는 -> 개수 순 (오름차순)
            if(box.to == this.to)   return this.from - box.from;
            return this.to - box.to;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 마을의 개수
        int c = Integer.parseInt(st.nextToken());   // 트럭의 용량

        int m = Integer.parseInt(br.readLine());    // 박스 정보의 수
        Box[] boxes = new Box[m];
        int[] count = new int[n + 1];   // 마을에 도착했을 때 트럭에 실은 박스의 수
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());    // 보내는 마을
            int to = Integer.parseInt(st.nextToken());      // 받는 마을
            int box = Integer.parseInt(st.nextToken());   // 개수
            boxes[i] = new Box(from, to, box);
        }
        Arrays.sort(boxes);

        int sum = 0;
        for(Box box : boxes){
            int max = 0;
            boolean isLoad = true;
            for(int i = box.from; i < box.to; i++){
                if(count[i] >= c){
                    isLoad = false;
                    break;
                }
                max = Math.max(max, count[i]);
            }
            if(isLoad){
                int unload = c - max;   // 최대 용량에서 남은 박스 수
                if(unload > box.count)  unload = box.count; // 내린 박스의 수가 더 작으면
                sum += unload;
                for(int i = box.from; i < box.to; i++){
                    count[i] += unload;
                }
            }
        }

        System.out.println(sum);
    }
}

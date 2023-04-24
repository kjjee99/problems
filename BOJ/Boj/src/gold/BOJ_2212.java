package gold;

/**
 * 센서
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] lines = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            lines[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines);
        int result = 0;
        Integer[] sub = new Integer[n-1];
        if(n > k) {
            for (int i = 0; i < n - 1; i++){
               sub[i] = lines[i + 1] - lines[i];
            }
            Arrays.sort(sub, Collections.reverseOrder());

            for(int i = k - 1; i < n - 1; i++){
                result += sub[i];
            }
        }

        System.out.println(result);
    }
}

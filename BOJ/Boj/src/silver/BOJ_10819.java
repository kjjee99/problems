package silver;

/**
 * 차이를 최대로
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
    private static int[] arr, result;
    private static boolean[] visited;
    private static int n, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int count){
        if(count == n){
            int sum = 0;
            for(int i = 0; i < n - 1; i++){
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[count] = arr[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}

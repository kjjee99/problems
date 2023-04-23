package etc;

/**
 * 코드트리
 * 놀이기구 탑승
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeTree_AmusementPark {

    static class Friend implements Comparable<Friend>{
        int x, y, friendCount, blankCount;
        public Friend(int x, int y, int friendCount, int blankCount){
            this.x = x;
            this.y = y;
            this.friendCount = friendCount;
            this.blankCount = blankCount;
        }

        @Override
        public int compareTo(Friend friend){
            // 친구 -> 공백 -> x -> y
            if(friend.friendCount == this.friendCount){
                if(friend.blankCount == this.blankCount){
                    if(friend.x == this.x){
                        return this.y - friend.y;
                    }
                    return this.x - friend.x;
                }
                return friend.blankCount - this.blankCount;
            }
            return friend.friendCount - this.friendCount;
        }
    }

    private static int n;
    private static int[] dx = {-1, 0, 1, 0};    // 상 좌 하 우
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] attraction, map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n * n + 1][n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n * n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            q.add(index);   // 칸에 넣을 순서
            for(int j = 0; j < 4; j++){
                int x = Integer.parseInt(st.nextToken());
                map[index][x] = 1;
            }
        }

        attraction = new int[n][n];
        while(!q.isEmpty()){
            getIn(q.poll());
        }

        System.out.println(getScore());
    }

    // 기구에 탑승
    private static void getIn(int num){
        List<Friend> list = new ArrayList<>();
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                if(attraction[x][y] == 0){
                    int blanks = 0;     // 공백의 수
                    int friends = 0;    // 친구의 수
                    for(int d = 0; d < 4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(attraction[nx][ny] == 0)  blanks++;
                        else if(map[num][attraction[nx][ny]] == 1) friends++;
                    }
                    list.add(new Friend(x, y, friends, blanks));
                }
            }
        }
        Collections.sort(list);
        Friend best = list.get(0);
        attraction[best.x][best.y] = num;
    }

    private static int getScore(){
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int friends = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(map[attraction[i][j]][attraction[nx][ny]] == 1) friends++;
                }
                if(friends == 4)    result += 1000;
                else if(friends == 3) result += 100;
                else if(friends == 2) result += 10;
                else result += friends;
            }
        }
        return result;
    }
}
package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 청소년 상어
 */
public class BOJ_19236 {
    static class Shark{
        int x, y, ate, direction;
        public Shark(int x, int y, int ate, int direction){
            this.x = x;
            this.y = y;
            this.ate = ate;
            this.direction = direction;
        }
    }
    static class Fish{
        int x, y, weight, direction;
        boolean isAlive = true;
        public Fish(int x, int y, int weight, int direction, boolean isAlive){
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.direction = direction;
            this.isAlive = isAlive;
        }
    }
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[4][4];
        List<Fish> fishes = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j ++){
                int w = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                fishes.add(new Fish(i, j, w, d, true));
                map[i][j] = w;
            }
        }

        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.weight - o2.weight;
            }
        });

        // Setting Shark
        Fish ateFish = fishes.get(map[0][0] - 1);
        Shark shark = new Shark(0,0, ateFish.weight, ateFish.direction);
        ateFish.isAlive = false;
        map[0][0] = -1;

        dfs(map, shark, fishes);
        System.out.println(maxSum);
    }

    // 반복
    private static void dfs(int[][] arr, Shark shark, List<Fish> fishes){
        if(maxSum < shark.ate){
            maxSum = shark.ate;
        }
        // 물고기 움직이기
        move(arr, fishes);
        // 상어 식사
        for(int d = 1; d < 4; d++){
            int nx = shark.x + d * dx[shark.direction];
            int ny = shark.y + d * dy[shark.direction];
            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] > 0){
                int[][] arrCopy = copyArray(arr);
                List<Fish> fishCopy = copyFishes(fishes);

                arrCopy[shark.x][shark.y] = 0;
                Fish fish = fishCopy.get(arr[nx][ny] - 1);
                Shark newShark = new Shark(fish.x, fish.y, shark.ate + fish.weight, fish.direction);
                fish.isAlive = false;
                arrCopy[fish.x][fish.y] = -1;

                dfs(arrCopy, newShark, fishCopy);
            }
        }
    }

    // 물고기 이동
    private static void move(int[][] arr, List<Fish> fishes) {
        for(int i = 0; i < 16; i++){
            Fish fish = fishes.get(i);
            if(!fish.isAlive) continue;

            for(int d = 0; d < 8; d++){
                int direction = (fish.direction + d) % 8;
                int nx = fish.x + dx[direction];
                int ny = fish.y + dy[direction];
                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] > -1){
                    arr[fish.x][fish.y] = 0;

                    if(arr[nx][ny] == 0) {
                        fish.x = nx;
                        fish.y = ny;
                    }else {
                        Fish tmp = fishes.get(arr[nx][ny] - 1);
                        tmp.x = fish.x;
                        tmp.y = fish.y;
                        arr[fish.x][fish.y] = tmp.weight;
                        fish.x = nx;
                        fish.y = ny;
                    }

                    arr[nx][ny] = fish.weight;
                    fish.direction = direction;
                    break;
                }
            }
        }
    }

    private static int[][] copyArray(int[][] arr){
        int[][] temp = new int[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    private static List<Fish> copyFishes(List<Fish> fishes){
        List<Fish> temp = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            Fish fish = fishes.get(i);
            temp.add(new Fish(fish.x, fish.y, fish.weight, fish.direction, fish.isAlive));
        }
        return temp;
    }
}

/**
 * [구명보트] https://school.programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 가장 작은 몸무게와 가장 큰 몸무게가 제한을 넘어가지 않으면 됨
 */

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int idx = 0, boat = 0;
        for(int i = people.length - 1; i >= idx; i--){
            // 가장 큰 몸무게 + 가장 작은 몸무게
            if(people[i] + people[idx] <= limit){
                idx++;
                boat++;
            } else {    // 혼자서라도 보트를 타야함
                boat++;
            }
        }

        return boat;
    }
}
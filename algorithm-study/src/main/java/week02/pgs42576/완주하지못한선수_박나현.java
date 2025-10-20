package week02.pgs42576;

import java.util.*;

public class 완주하지못한선수_박나현 {

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> hashMap = new HashMap<>();

            for (String p : participant) {
                hashMap.put(p, hashMap.getOrDefault(p, 0) +1);
            }

            for (String c : completion) {
                int value = hashMap.get(c);
                if (value != 0) hashMap.put(c, value - 1);
            }

            for (String key : hashMap.keySet()) {
                if (hashMap.get(key) != 0) answer = key;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스 1
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(sol.solution(participant1, completion1)); // 출력: leo

        // 테스트 케이스 2
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(sol.solution(participant2, completion2)); // 출력: vinko

        // 테스트 케이스 3 (동명이인)
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(sol.solution(participant3, completion3)); // 출력: mislav
    }


}

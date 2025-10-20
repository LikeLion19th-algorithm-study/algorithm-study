package week02.pgs42578;

import java.util.HashMap;

public class 의상_박나현 {

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String[] cloth : clothes) {
                String type = cloth[1];
                hashMap.put(type, hashMap.getOrDefault(type, 0)+1);
            }
            for (int i : hashMap.values()) {
                answer *= (i + 1);
            }
            return answer - 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 테스트 케이스 1
        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println("answer: " + s.solution(clothes1)); // 5

        // 테스트 케이스 2
        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        System.out.println("answer: " + s.solution(clothes2)); // 3
    }
}

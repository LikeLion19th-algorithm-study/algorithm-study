package week02.pgs1845;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬_박나현 {

    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n);
            return  Math.min(nums.length / 2, set.size());
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스 1
        int[] nums1 = {3, 1, 2, 3};
        System.out.println(sol.solution(nums1)); // 출력: 2

        // 테스트 케이스 2
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println(sol.solution(nums2)); // 출력: 3

        // 테스트 케이스 3
        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println(sol.solution(nums3)); // 출력: 2
    }
}

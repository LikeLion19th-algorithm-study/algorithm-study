package week02.pgs1845;
import java.util.*;
import java.io.*;

public class 폰켓몬_심민아 {
    public static void main(String[] args) throws IOException {
        Solution s = new 폰켓몬_심민아().new Solution();

        System.out.println(s.solution(new int[]{3,1,2,3}));         // 기대: 2
        System.out.println(s.solution(new int[]{3,3,3,2,2,4}));     // 기대: 3
        System.out.println(s.solution(new int[]{3,3,3,2,2,2}));
    }

    class Solution {
        public int solution(int[] nums) {
            Set<Integer> types = new HashSet<>();
            for(int num : nums) {
                types.add(num);
            }

            int maxSelect = nums.length / 2;

            return Math.min(types.size(), maxSelect);
        }
    }
}

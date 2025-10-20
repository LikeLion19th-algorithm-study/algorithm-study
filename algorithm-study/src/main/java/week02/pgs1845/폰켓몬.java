package week02.pgs1845;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {
        // 최대 선택 수 = 전체의 절반
        int maxChoose = nums.length / 2;

        // 서로 다른 종류의 수를 세기 위해 Set 사용
        Set<Integer> types = new HashSet<>();

        for (int n : nums) {
            types.add(n);
            // 최적화를 위해 종류 수가 이미 maxChoose를 넘으면 반복 종료 가능
            if (types.size() == maxChoose) {
                // 더 이상 늘어나도 답은 maxChoose 이므로 바로 반환
                return maxChoose;
            }
        }

        // 가능한 서로 다른 종류 수와 maxChoose 중 작은 값
        return Math.min(types.size(), maxChoose);
    }
}

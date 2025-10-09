package week02.pgs1845;

import java.util.HashSet;
import java.util.Set;

/**
 * 연구실에 있는 N 마리의 폰켓몬 중 N/2 마리를 가져간다.
 * 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택한다.
 * N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾는다.
 */
public class 폰켓몬_정다희 {
    public int solution(int[] nums) {

        // 중복 제거를 위해 HashSet 사용
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 가져갈 수 있는 폰켓몬보다 중복제거한 Set의 size가 클 경우, 최대로 가져갈 수 있는 폰켓몬만 가져간다.
        if(set.size() > nums.length/2) return nums.length;

        // 그게 아닐경우 중복 제거한 폰켓몬을 가져가면 됨.
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};

        폰켓몬_정다희 s = new 폰켓몬_정다희();
        System.out.println(s.solution(nums));
    }
}

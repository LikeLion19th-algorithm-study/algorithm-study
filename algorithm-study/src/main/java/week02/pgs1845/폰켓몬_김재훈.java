package week02.pgs1845;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
 * N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법
 * nums는 폰켓몬의 종류 번호가 담긴 1차원 배열이며, 길이는 항상 짝수로 주어진다.
 */
public class 폰켓몬_김재훈 {

    // HashSet을 사용한 풀이
    public static int solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // set의 사이즈가 nums / 2 보다 클 경우 nums / 2 를 반환하면 된다. (예 #1 set.size() = 3, nums,length / 2 = 2) => return 2)
        // set의 사이즈가 nums / 2 보다 작은 경우 set의 사이즈를 반환하면 된다. (예 #3 set.size() = 2, nums.length / 2 = 3 => return 2))
        return Math.min(set.size(), nums.length / 2);
    }

    // HashMap을 사용한 풀이
    public static int solution2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        // map의 사이즈가 nums / 2 보다 클 경우 nums / 2 를 반환하면 된다. (예 #1 map.size() = 3, nums,length / 2 = 2) => return 2)
        // map의 사이즈가 nums / 2 보다 작은 경우 map의 사이즈를 반환하면 된다. (예 #3 map.size() = 2, nums.length / 2 = 3 => return 2))
        return Math.min(map.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        int result1 = solution1(nums1);
        int result2 = solution2(nums2);

        System.out.println(result1);
        System.out.println(result2);
    }
}

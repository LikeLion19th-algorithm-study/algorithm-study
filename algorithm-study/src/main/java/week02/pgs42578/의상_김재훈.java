package week02.pgs42578;

import java.util.HashMap;
import java.util.Map;

/**
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * 코니는 하루에 최소 한 개의 의상은 입습니다.
 * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class 의상_김재훈 {

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // {의상, 타입} 순의 배열이기 때문에 1번 인덱스의 값(타입)을 Key로 맵에 저장한다.
        // 조합의 수만 구하면 되기 때문에 있을 때마다 +1씩 해준다.
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.compute(type, (k, v) -> v == null ? 1 : v + 1);
        }

        // 안 입는 경우를 포함하여 (타입의 옷 개수 + 1)만큼씩 곱한다.
        // 하루에 최소 한 개의 의상은 입기 때문에 모두 입지 않는 경우를 하나 제외한다.
        return map.values()
                .stream()
                .reduce(1, (a, b) -> a * (b + 1)) - 1;
    }

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }
}

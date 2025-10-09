package week02.pgs42578;

import java.util.HashMap;
import java.util.Map;

public class 의상_정다희 {
    public int solution(String[][] clothes) {

        // 1. 맵에 옷의 종류와, 그 종류가 몇가지 인지만 넣는다.
        Map<String, Integer> map = new HashMap<>();
        for (String[] item : clothes) {
            String type = item[1]; // index가 1에 있는게 종류

            // key값에 type을 넣고, 기존값을 가져와서 +1 한다.
            // 처음 들어가면 1이 들어가고, 두번째 들어가면 1에서 +1 하므로 2가 된다.
            // 따라서 종류가 2개 일 경우 (중복 될 경우) 숫자 2가 들어감.
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1; // 곱셈 누적을 하려면 첫 시작이 1이어야 함.

        for(int cnt : map.values()) {
            answer *= (cnt + 1); // 안입는 경우도 추가해야 하기 때문에 +1
        }

        return answer - 1; // 모두 안 입는 경우는 빼야하기 때문에 -1
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        의상_정다희 s = new 의상_정다희();
        System.out.println(s.solution(clothes));
    }
}

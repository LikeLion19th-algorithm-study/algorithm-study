package week02.pgs42578;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {
        // 종류별 의상 개수 저장
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류별 개수
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        // 각 의상 종류마다 (선택할 수 있는 수 + 안 입는 경우 1) 곱하기
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 모두 안 입는 경우 1을 빼기
        return answer - 1;
    }
}

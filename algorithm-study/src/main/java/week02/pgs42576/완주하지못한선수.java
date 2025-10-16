package week02.pgs42576;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        // 중복 이름이 있을 수 있으므로 해시 맵 사용
        Map<String, Integer> countMap = new HashMap<>();

        // 참가자 수
        for (String p : participant) {
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }

        // 완주자 수 빼기
        for (String c : completion) {
            countMap.put(c, countMap.get(c) - 1);
        }

        // 남아있는(카운트 > 0) 사람이 완주하지 못한 선수
        for (String p : participant) {
            if (countMap.get(p) != null && countMap.get(p) > 0) {
                return p;
            }
        }

        return "";
    }
}

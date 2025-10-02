package week02.pgs42576;

import java.util.HashMap;
import java.util.Map;

/**
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * <p>
 * 정확성: 58.3 / 효율성: 41.7
 */
public class 완주하지못한선수_김재훈 {

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>(); // key = 이름, value = 참가자 수
        String answer = "";

        for (String participantName : participant) {
            map.compute(participantName, (k, v) -> v == null ? 1 : v + 1);
        }

        for (String completionName : completion) {
            map.compute(completionName, (k, v) -> v == null ? 0 : v - 1);
        }

        // completion의 길이는 participant의 길이보다 1 작기 때문에 value가 0이 아닌 key가 한 개만 남는다.
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                answer = name;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        String result = solution(participant, completion);
        System.out.println(result);
    }
}

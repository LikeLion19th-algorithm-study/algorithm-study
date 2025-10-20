package week02.boj1764;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
 * 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
 * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어진다.
 * 듣도 못한 사람의 명단과 보도 못한 사람의 명단은 중복이 없다.
 * 듣보잡의 수와 그 명단을 사전순으로 출력한다.
 * <p>
 * 시간: 328ms / 메모리: 29648KB
 */
public class 듣보잡_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            map.compute(br.readLine(), (k, v) -> v == null ? 1 : v + 1);
        }

        while (m-- > 0) {
            map.compute(br.readLine(), (k, v) -> v == null ? 1 : v + 1);
        }

        // Map의 Value 값이 2인 사람은 둘 다 포함되는 사람이므로 해당 사람들을 정렬하여 배열로 반환
        List<String> result = map.entrySet().stream()
                .filter(v -> v.getValue() == 2)
                .map(Map.Entry::getKey)
                .sorted()
//                .toList(); // Java 16 이상에서 도입된 메서드이므로 백준(Java 11)에서는 사용 불가
                .collect(Collectors.toList());

        sb.append(result.size()).append("\n"); // 듣보잡의 수
        result.forEach(v -> sb.append(v).append("\n")); // 듣보잡의 명단
        System.out.println(sb);
    }
}

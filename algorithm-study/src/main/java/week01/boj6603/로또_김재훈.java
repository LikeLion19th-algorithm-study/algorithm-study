package week01.boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 * 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
 * S의 원소는 오름차순으로 주어진다.
 * StringBuilder 사용 전 수행시간: 272ms
 * StringBuilder 사용 후 수행시간: 112ms
 */
public class 로또_김재훈 {

    static boolean[] visited;
    static int[] arr;
    // 결과를 담을 배열
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] split = br.readLine().split(" ");
            // 주어지는 수의 개수
            int k = Integer.parseInt(split[0]);

            // 0이 입력되면 종료
            if (k == 0) break;

            // 읽어들인 문자 배열을 숫자 배열로 변환
            arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i + 1]);
            }

            visited = new boolean[k];
            result = new int[6];

            backtracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    /*
     * 한 번 조합된 배열은 다시 나오지 않아야 한다.
     * 따라서 반복문의 i의 값이 항상 0부터 시작하는 것이 아니라, 순차적으로 커져야 한다.
     */
    static void backtracking(int start, int depth) {
        if (depth == result.length) {
            for (int value : result) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                // 재귀 호출
                backtracking(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}

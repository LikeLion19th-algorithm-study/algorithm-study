package week01.boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 문제: 로또
 * 주어진 숫자 중 6개를 고르는 모든 조합을 출력하는 문제
 * 입력:
 *   첫 번째 수: 숫자의 개수 k (6 <= k <= 13)
 *   그 뒤 k개의 숫자 (오름차순)
 *   k가 0이면 입력 종료
 * 출력:
 *   6개 숫자의 조합을 한 줄씩 출력
 *   각 테스트 케이스 사이에는 빈 줄 추가
 * 알고리즘:
 *   백트래킹(조합 생성)
 */
public class 로또_박나현 {

    /**
     * 예제 입력:
     *   7 1 2 3 4 5 6 7
     *   8 1 2 3 5 6 7 8 9
     *   0
     */
    static StringBuilder sb = new StringBuilder();
    static int[] numbers; // 입력받은 k개의 숫자
    static int[] arr = new int[6]; // 현재 조합을 임시로 담는 배열
    static int k; // 입력받을 숫자의 개수 k

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            // StringTokenizer는 한 줄 문자열을 대상으로 동작하기 때문에,
            // StringTokenizer를 매 줄 새로 생성해줘야 한다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;
            numbers = new int[k];

            // k개의 수를 차례대로 numbers에 넣기 위한 반복문
            for (int i = 0; i < k; i++) {
                int number = Integer.parseInt(st.nextToken());
                numbers[i] =  number;
            }
            backtrack(0,0);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backtrack(int start, int depth) {
        if (depth == 6) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 시작 인덱스부터, k까지 배열을 순회한다.
        for (int i = start; i < k; i++) {
            arr[depth] = numbers[i];

            // start = 0 -> start = 1 --> ~1~ 2 3 4 5 6 7
            // 이미 고른 숫자의 뒤 숫자를 고르기 위해 현재 인덱스+1 하여 재귀호출한다.
            backtrack(i+1, depth+1);
        }
    }
}

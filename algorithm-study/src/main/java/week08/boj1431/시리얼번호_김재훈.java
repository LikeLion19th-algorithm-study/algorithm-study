package week08.boj1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 기준
 * 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
 * 2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
 * 3. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
 * 메모리: 14436KB | 시간: 108ms
 */
public class 시리얼번호_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 기타의 개수 N

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length()) { // 서로 길이가 같다면
                int sum1 = 0;
                int sum2 = 0;

                for (int i = 0; i < a.length(); i++) {
                    int num = a.charAt(i) - '0';
                    if (num >= 0 && num <= 9) {
                        sum1 += num; // a의 모든 자리수의 숫자 합
                    }
                }

                for (int i = 0; i < b.length(); i++) {
                    int num = b.charAt(i) - '0';
                    if (num >= 0 && num <= 9) {
                        sum2 += num; // b의 모든 자리수의 숫자 합
                    }
                }

                if (sum1 == sum2) { // 1,2번 둘 조건으로도 비교할 수 없으면
                    return a.compareTo(b); // 사전순 비교
                }

                return sum1 - sum2;
            } else { // 길이가 다르면
                return a.length() - b.length(); // 짧은 것이 먼저 온다.
            }
        });

        Arrays.stream(arr).forEach(v -> sb.append(v).append("\n"));
        System.out.println(sb);
    }
}

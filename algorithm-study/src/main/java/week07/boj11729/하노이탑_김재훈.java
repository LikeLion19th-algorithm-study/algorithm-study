package week07.boj11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 있다.
 * 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 메모리: 36808KB | 시간: 380ms
 */
public class 하노이탑_김재훈 {

    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 원판의 개수 N

        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);
    }

    /**
     *
     * @param n 원판의 개수
     * @param from 출발지
     * @param to 목적지
     * @param other 출발지와 목적지를 제외한 나머지 하나
     */
    private static void hanoi(int n, int from, int to, int other) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, other, to);
        count++;
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, other, to, from);
    }
}

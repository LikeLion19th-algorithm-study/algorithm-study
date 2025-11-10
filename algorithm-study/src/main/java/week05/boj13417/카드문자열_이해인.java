package week05.boj13417;

import java.io.*;
import java.util.*;

public class 카드문자열_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayDeque<Character> deque = new ArrayDeque<>();

            // 첫 번째 카드 삽입
            if (st.hasMoreTokens()) {
                deque.offer(st.nextToken().charAt(0));
            }

            // 이후 카드부터 앞/뒤 비교 삽입
            for (int i = 1; i < N; i++) {
                if (!st.hasMoreTokens()) break; // null 방지
                char current = st.nextToken().charAt(0);

                // 덱의 맨 앞 문자와 비교하여 삽입 위치 결정
                if (current <= deque.peekFirst()) {
                    deque.offerFirst(current);
                } else {
                    deque.offerLast(current);
                }
            }

            // 덱의 문자들을 순서대로 문자열로 변환
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}

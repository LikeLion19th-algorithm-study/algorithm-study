package week05.boj13417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 13417 카드 문자열
 * 메모리: 33460KB
 * 시간: 304ms
 *
 * @author dahee
 */
public class 카드문자열_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 총 테스트 수
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCount; i++) {
            int cardCount = Integer.parseInt(br.readLine()); // 카드의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Character> cards = new ArrayDeque<>(); // 카드를 새로운 문자열로 만들 Deque

            for (int j = 0; j < cardCount; j++) {
                char card = st.nextToken().charAt(0); // 알파벳 순서 비교를 위해 char로 변환
                if (cards.isEmpty() || card > cards.peekFirst()) {
                    // 1. 첫 카드 이거나
                    // 2. 맨 앞 카드가 현재 카드보다 알파벳이 뒤의 순서일 경우
                    cards.addLast(card); // 마지막에 추가
                } else {
                    // 1. 첫 카드가 아니거나
                    // 2. 맨 앞 카드가 현재 카드보다 앞의 순서이거나
                    // 3. 맨 앞 카드와 현재 카드가 같은 알파벳일 경우
                    cards.addFirst(card); // 앞에 추가
                }
            }

            // Dequq에 넣은 카드를 차례대로 StringBuilder에 append
            for (Character card : cards) sb.append(card);
            // 마지막 카드면 줄바꿈
            if (i < testCount - 1) sb.append("\n");
        }

        System.out.println(sb);
    }
}

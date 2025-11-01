package week05.boj13417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * N장의 카드가 일렬로 놓여있다. 각 카드에는 알파벳이 하나씩 적혀있다.
 * 가장 왼쪽에 있는 카드부터 차례대로 한 장씩 가져올 수 있다.
 * 그다음부터는 가져온 카드를 자신의 앞에 놓인 카드들의 가장 왼쪽, 또는 가장 오른쪽에 놓는다.
 * 만들 수 있는 문자열 중 사전 순으로 가장 빠른 문자열
 * <p>
 * 첫째 줄에 테스트 케이스의 개수를 나타내는 자연수 T
 * 각각의 테스트 케이스의 첫째 줄에 처음에 놓여있는 카드의 개수 N(1 ≤ N ≤ 1,000)
 * 두 번째 줄에는 N장의 카드에 적힌 알파벳의 초기 순서
 *
 * 메모리: 29584KB / 시간: 304ms
 */
public class 카드문자열_김재훈 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); // 테스트 케이스의 개수 T

        while (t-- > 0) {
            Deque<String> cards = new ArrayDeque<>();
            Deque<String> result = new ArrayDeque<>();

            int n = Integer.parseInt(br.readLine()); // 카드의 개수 N
            initCard(br, n, cards);

            while (!cards.isEmpty()) {
                solution(cards, result);
            }

            result.forEach(sb::append);

            if (t != 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void initCard(BufferedReader br, int n, Deque<String> deque) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.offer(st.nextToken()); // 알파벳 순서대로 놓기
        }
    }

    private static void solution(Deque<String> cards, Deque<String> result) {
        if (result.isEmpty()) { // result가 비었을 경우 우선 하나를 먼저 넣어준다.
            result.offer(cards.pollFirst());
            return;
        }

        String dequeFirst = cards.peekFirst();
        String resultFirst = result.peekFirst();
        int compared = resultFirst.compareTo(dequeFirst);
        // 양수(또는 0)일 경우 result 쪽 알파벳이 큰(또는 같은) 것이므로 왼쪽(앞쪽)으로 배치
        // 음수일 경우 result 쪽 알파벳이 작은 것이므로 오른쪽(뒤쪽)으로 배치

        if (compared >= 0) {
            result.offerFirst(cards.pollFirst());
        } else {
            result.offerLast(cards.pollFirst());
        }
    }
}

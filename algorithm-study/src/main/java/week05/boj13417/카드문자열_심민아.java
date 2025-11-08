package week05.boj13417;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
public class 카드문자열_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] cards = new char[N];
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken().charAt(0);
            }

            Deque<Character> deque = new ArrayDeque<>();
            deque.offer(cards[0]); // 첫 번째 카드는 무조건 놓기

            for (int i = 1; i < N; i++) {
                char current = cards[i];


                // 현재 카드가 맨 앞 카드보다 작거나 같으면 왼쪽에
                if (current <= deque.peekFirst()) {
                    deque.offerFirst(current);
                } else { // 현재 카드가 맨 앞 카드보다 작거나 같으면 오른쪽에
                    deque.offerLast(current);
                }
            }


            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
            result.append(sb).append("\n");
        }

        System.out.print(result);
    }
}

package week05.boj10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 명령은 총 여덟 가지이다.
 * <p>
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * <p>
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 * <p>
 * 메모리: 18356KB / 시간: 168ms
 */
public class 덱_김재훈 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            solution(br);
        }

        System.out.println(sb);
    }

    private static void solution(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();

        switch (command) {
            case "push_front":
                deque.offerFirst(Integer.parseInt(st.nextToken()));
                break;

            case "push_back":
                deque.offerLast(Integer.parseInt(st.nextToken()));
                break;

            case "pop_front":
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                break;

            case "pop_back":
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                break;

            case "size":
                sb.append(deque.size()).append("\n");
                break;

            case "empty":
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;

            case "front":
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                break;

            case "back":
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                break;
        }
    }
}

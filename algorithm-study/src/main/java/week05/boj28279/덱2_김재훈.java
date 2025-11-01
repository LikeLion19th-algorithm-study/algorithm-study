package week05.boj28279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 명령은 총 여덟 가지이다.
 * <p>
 * 1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
 * 2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
 * 3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 5: 덱에 들어있는 정수의 개수를 출력한다.
 * 6: 덱이 비어있으면 1, 아니면 0을 출력한다.
 * 7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * <p>
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 * <p>
 * 메모리: 259756KB / 시간: 1068ms
 */
public class 덱2_김재훈 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 명령의 수 N

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
            case "1":
                int inputFirst = Integer.parseInt(st.nextToken());
                deque.offerFirst(inputFirst);
                break;
            case "2":
                int inputLast = Integer.parseInt(st.nextToken());
                deque.offerLast(inputLast);
                break;
            case "3":
                sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
                break;
            case "4":
                sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
                break;
            case "5":
                sb.append(deque.size()).append("\n");
                break;
            case "6":
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;
            case "7":
                sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
                break;
            case "8":
                sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                break;
        }
    }
}

package week04.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램 작성
 * 명령은 총 여섯 가지
 * <p>
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * <p>
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * <p>
 * ArrayDeque 사용 시 메모리: 19000KB / 시간: 164ms
 * LinkedList 사용 시 메모리: 18636KB / 시간: 160ms
 */
public class 큐_김재훈 {

    static Queue<Integer> queue = new ArrayDeque<>();
//    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 명령의 수 N
        int num = 0; // 큐에 가장 최근에 넣은 정수를 찾기 위한 변수 선언

        while (n-- > 0) {
            num = solution(br, num);
        }
        System.out.println(sb);
    }

    private static int solution(BufferedReader br, int num) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();

        switch (command) {
            case "push":
                num = Integer.parseInt(st.nextToken()); // 정수 X
                queue.offer(num); // 정수 X를 큐에 넣는 연산
                break;

            case "pop":
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                // 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                break;

            case "size":
                sb.append(queue.size()).append("\n"); // 큐에 들어있는 정수의 개수를 출력
                break;

            case "empty":
                sb.append(queue.isEmpty() ? 1 : 0).append("\n"); // 큐가 비어있으면 1, 아니면 0을 출력
                break;

            case "front":
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                break;

            case "back":
                sb.append(queue.isEmpty() ? -1 : num).append("\n");
                // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                // 가장 뒤에 있는 정수 == 큐에 가장 최근에 넣은 정수
                // Deque에서는 peekLast 메서드 사용 가능
                break;
        }
        return num;
    }
}

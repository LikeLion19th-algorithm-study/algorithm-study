package week04.boj2164;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N장의 카드가 있다.
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
 * 우선, 제일 위에 있는 카드를 바닥에 버린다.
 * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 동작을 카드가 한 장 남을 때까지 반복하게 된다.
 * N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
 * <p>
 * ArrayDeque 사용 시 메모리: 28636KB / 시간: 172ms
 * LinkedList 사용 시 메모리: 45508KB / 시간: 168ms
 */
public class 카드2_김재훈 {

    static Queue<Integer> queue = new ArrayDeque<>();
//    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken()); // 정수 N

        initCard(n);
        solution();
        sb.append(queue.poll());
        System.out.println(sb);

/*      실패 (메모리 초과)

        while (!queue.isEmpty()) {
            queue.poll(); // 제일 위에 있는 카드 버리기

            if (queue.size() == 1) {
                break; // 카드가 한 장 남았다면 반복문 탈출
            }

            queue.offer(queue.poll()); // 제일 위에 있는 카드를 제일 아래로 옮기기
        }
*/
    }

    private static void initCard(int n) {
        for (int i = 1; i <= n; i++) {
            queue.offer(i); // 순서대로 카드 놓기
        }
    }

    private static void solution() {
        while (queue.size() > 1) { // 카드가 한 장 남을 때까지 반복
            queue.poll(); // 제일 위에 있는 카드 버리기
            queue.offer(queue.poll()); // 제일 위에 있는 카드를 제일 아래로 옮기기
        }
    }
}

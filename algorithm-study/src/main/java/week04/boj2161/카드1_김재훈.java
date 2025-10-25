package week04.boj2161;

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
 * <p>
 * ArrayDeque 사용 시 메모리: 14320KB / 시간: 112ms
 * LinkedList 사용 시 메모리: 14304B / 시간: 108ms
 */
public class 카드1_김재훈 {

    static Queue<Integer> queue = new ArrayDeque<>();
//    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정수 N

        initCard(n);
        solution();
        System.out.println(sb);
    }

    private static void initCard(int n) {
        for (int i = 1; i <= n; i++) {
            queue.offer(i); // 순서대로 카드 놓기
        }
    }

    private static void solution() {
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" "); // 제일 위에 있는 카드 버리기

            if (queue.isEmpty()) {
                break; // 카드를 버린 뒤 큐가 비었다면 반복문 탈출
            }

            queue.offer(queue.poll()); // 제일 위에 있는 카드를 제일 아래로 옮기기
        }
    }
}

package week04.boj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 * 순서대로 K번째 사람을 제거한다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
 * 예) (7, 3)-요세푸스 순열 = {3, 6, 2, 7, 5, 1, 4}
 * <p>
 * ArrayDeque 사용 시: 메모리: 14572KB / 시간: 132ms
 * LinkedList 사용 시: 메모리: 23572KB / 시간: 144ms
 */
public class 요세푸스문제_김재훈 {

    static Queue<Integer> queue = new ArrayDeque<>();
//    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // N명의 사람
        int k = Integer.parseInt(st.nextToken()); // K번째 사람

        sb.append("<");
        initQueue(n);
        solution(k);
        System.out.println(sb);
    }

    private static void initQueue(int n) {
        for (int i = 1; i <= n; i++) {
            queue.offer(i); // 순서대로 큐에 넣기
        }
    }

    private static void solution(int k) {
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">"); // 큐의 사이즈가 1이 되면 k번 반복할 필요 없이 바로 결과값에 추가
                break;
            }

            for (int i = 0; i < k - 1; i++) { // k번째 수를 결과값에 추가해야 하기 때문에 k-1 만큼 반복
                queue.offer(queue.poll()); // 계속 반복해야 하기 때문에 가장 앞의 수를 큐의 가장 뒤에 추가
            }

            sb.append(queue.poll()).append(", "); // k번째 수가 가장 앞에 있을 것이기 때문에 결과값에 추가
        }
    }
}

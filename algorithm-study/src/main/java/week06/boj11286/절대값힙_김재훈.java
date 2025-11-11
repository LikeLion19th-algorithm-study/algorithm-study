package week06.boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 * N개의 줄에 연산에 대한 정보를 나타내는 정수 x
 * x가 0이 아니라면 배열에 x 추가, x가 0이라면 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
 * 절댓값이 가장 작은 값이 여러 개일 때는 가장 작은 수를 출력하고 그 값을 배열에서 제거
 * 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우 0을 출력
 * 메모리: 26596KB | 시간: 276ms
 */
public class 절대값힙_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) { // 절댓값이 같으면 더 작은 수가 우선순위
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b); // 절대값이 작은 수가 우선순위
            }
        });

        int n = Integer.parseInt(br.readLine()); // 연산의 개수 N

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보를 나타내는 정수 x

            if (x == 0) {
                if (pq.isEmpty()) { // 배열이 비어 있는 경우인데 출력하라고 한 경우
                    sb.append(0).append("\n"); // 0을 출력한다.
                    continue;
                }
                sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}

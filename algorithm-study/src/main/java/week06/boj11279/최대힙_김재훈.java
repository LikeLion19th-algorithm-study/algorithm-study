package week06.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 최대힙 연산 프로그램
 * N개의 줄에 연산에 대한 정보를 나타내는 정수 x
 * x가 자연수라면 배열에 x 추가, x가 0이라면 가장 큰 값을 출력하고 그 값을 배열에서 제거
 * 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우 0을 출력
 * 메모리: 26876KB | 시간: 292ms
 */
public class 최대힙_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 연산의 개수 N

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보를 나타내는 정수 x

            if (x == 0) { // 배열에서 가장 큰 값 출력
                if (pq.isEmpty()) { // 배열이 비어있는 경우에는 0을 출력
                    sb.append(0).append("\n");
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

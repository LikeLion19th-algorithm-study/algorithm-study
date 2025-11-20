package week06.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * BOJ 11279 최대 힙
 * 메모리: 26088KB
 * 시간: 276ms
 *
 * @author dahee
 */
public class 최대힙_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        /*
         * (a, b) -> b - a로 작성했었으나 민아님 코드보고 수정..!
         * Collection.reversOrder() 쓰는게 더 좋은 이유
         * 1. 숫자가 크면 오버플로우 버그가 발생할 수 있다.
         * 2. 코드 의도가 명확함
         */
        // 오름차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) pq.offer(x); // 0이 아니면 추가
            else sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}

package week06.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        // 오름차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) pq.offer(x); // 0이 아니면 추가
            else sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}

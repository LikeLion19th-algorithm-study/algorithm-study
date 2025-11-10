package week06.boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/**
 * BOJ 11286 절댓값 힙
 * 메모리: 24520KB
 * 시간: 276ms
 *
 * @author dahee
 */
public class 절댓값힙_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // 힙이 정렬을 위해 비교하는 두 원소 a, b의 절대값
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) return a - b; // 절대값이 같으면 실제 값을 비교
            else return absA - absB; // 아니면 절대값이 작은 쪽을 우선순위로
        });

        for (int i = 0; i < n; i++) {
            int x =  Integer.parseInt(br.readLine());

            if (x != 0) pq.offer(x); // 0이 아니면 추가
            else sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n"); // 비어있으면 0을 넣고 아니면 가장 작은값 출력후 제거
        }

        System.out.println(sb);
    }
}

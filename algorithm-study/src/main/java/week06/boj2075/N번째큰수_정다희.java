package week06.boj2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 2075 N번째 큰 수
 * 메모리: 216420KB
 * 시간: 764ms
 *
 * @author dahee
 */
public class N번째큰수_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N번째 큰 수를 알고 싶으므로 상위 N개만 넣어두면 됨
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);

        for (int i = 0; i < N; i++) {
            // N줄 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // N개 반복
                int x = Integer.parseInt(st.nextToken());
                if (pq.size() < N) {
                    // N보다 pq에 들어있는 숫자가 작으면 추가
                    pq.offer(x);
                } else if (x > pq.peek()) {
                    // 입력 숫자가 첫번재 숫자보다 크다면
                    pq.poll(); // 가장 작은 수 빼고
                    pq.offer(x); // 입력 숫자를 넣음
                }
            }
        }

        System.out.println(pq.peek());
    }
}

package week06.boj2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N개의 상위 값만 보관할 최소힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                minHeap.offer(num); // 현재 값 힙 삽입

                // 힙 크기가 N보다 크면 가장 작은 값을 제거 → 상위 N개의 값만 유지
                if (minHeap.size() > N) {
                    minHeap.poll();
                }
            }
        }

        // 힙의 루트 값이 N번째 큰 수
        System.out.println(minHeap.peek());
    }
}

// 메모리: 216036 KB
// 시간: 748 ms
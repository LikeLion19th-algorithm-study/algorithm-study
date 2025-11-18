package week06.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대힙_이해인 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 최소힙 (기본 PriorityQueue는 오름차순, 최소값이 루트)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());

                if (minHeap.size() < N) {
                    // 아직 상위 N개가 다 안 찼으면 그냥 추가
                    minHeap.offer(x);
                } else {
                    // 힙이 N개 찼다면, 현재 가장 작은 값과 비교
                    if (x > minHeap.peek()) {
                        // 새 값이 더 크면, 가장 작은 값 하나 빼고 새 값 넣기
                        minHeap.poll();
                        minHeap.offer(x);
                    }
                    // x가 더 작거나 같으면, 상위 N개에 못 들어감 → 버림
                }
            }
        }

        // 힙 안에는 전체 수 중 상위 N개만 남아 있고,
        // 그 중 가장 작은 값이 "N번째 큰 수"
        System.out.println(minHeap.peek());
    }
}

// 메모리: 27124 KB
// 시간: 312 ms
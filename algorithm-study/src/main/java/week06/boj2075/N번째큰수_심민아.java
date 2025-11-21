package week06.boj2075;
import java.io.*;
import java.util.*;

public class N번째큰수_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 최소 힙 생성 (크기를 N으로 유지)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                minHeap.offer(num);

                // 힙의 크기가 N을 초과하면 가장 작은 값 제거
                if (minHeap.size() > N) {
                    minHeap.poll();
                }
            }
        }

        // N번째 큰 수 = 힙에서 가장 작은 수
        System.out.println(minHeap.poll());
    }
}

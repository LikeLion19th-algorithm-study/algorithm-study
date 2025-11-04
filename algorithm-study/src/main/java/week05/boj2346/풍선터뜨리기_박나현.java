package week05.boj2346;

import java.util.*;
import java.io.*;

// 메모리: 15564KB | 시간: 164ms
public class 풍선터뜨리기_박나현 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // index 구하는 메서드가 없어 배열로 저장
        Deque<int[]> deq = new ArrayDeque<>();

        // size 만큼 deq에 값 저장
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            int n = Integer.parseInt(st.nextToken());
            deq.offer(new int[]{i, n});
        }

        int[] first = deq.pollFirst();
        sb.append(first[0]).append(" ");

        int next = first[1];

        while (!deq.isEmpty()) {
            if (next > 0) {
                for (int j = 0; j < next-1; j++) {
                    deq.offerLast(deq.poll());
                }
            } else {
                for (int j = 0; j < Math.abs(next); j++) {
                    deq.offerFirst(deq.pollLast());
                }
            }

            first = deq.poll();
            sb.append(first[0]).append(" ");
            next = first[1];
        }
        System.out.println(sb);
    }
}

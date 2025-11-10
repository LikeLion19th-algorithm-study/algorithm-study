package week05.boj20301;

import java.io.*;
import java.util.*;

public class 반전요세푸스_이해인 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 몇 번째 사람을 제거할지
        int M = Integer.parseInt(st.nextToken()); // M번 제거할 때마다 방향 반전

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean forward = true;
        int removedCnt = 0;

        while (!deque.isEmpty()) {
            if (forward) {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                // K번째 사람 제거
                int out = deque.pollFirst();
                sb.append(out).append('\n');
            } else {
                for (int i = 0; i < K - 1; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                int out = deque.pollLast();
                sb.append(out).append('\n');
            }

            removedCnt++;

            if (removedCnt % M == 0) {
                forward = !forward;
            }
        }

        System.out.print(sb);
    }
}

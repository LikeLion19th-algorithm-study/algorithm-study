package week05.boj20301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 반전요새푸스_심민아 {
    static Deque<Integer> q = new ArrayDeque<>();

    public static void rotateRight(int K) {
        for (int i = 0; i < K - 1; i++) {
            q.offerLast(q.pollFirst());
        }
    }

    public static void rotateLeft(int K) {
        for (int i = 0; i < K-1; i++) {
            q.offerFirst(q.pollLast());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean clockwise = true;
        int count = 0;

        while (!q.isEmpty()) {
            if (clockwise) {
                rotateRight(K);
                sb.append(q.pollFirst()).append("\n");
            } else {
                rotateLeft(K);
                sb.append(q.pollLast()).append("\n");
            }

            count++;

            if (count % M == 0) {
                clockwise = !clockwise;
            }
        }

        System.out.print(sb);

    }
}

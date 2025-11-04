package week05.boj20301;

import java.io.*;
import java.util.*;

public class 반전요세푸스_박나현 {
    static Deque<Integer> deq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static boolean turn = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deq.offerLast(i);
        }

        while (!deq.isEmpty()) {
            if (!turn) {
                turnRight(k);
            } else {
                turnLeft(k);
            }

            count++;
            if (count == m) {
                count = 0;
                turn = !turn;
            }
        }
        System.out.println(sb);
    }

    private static void turnRight(int k) {
        for (int i = 0; i < k-1; i++) {
            deq.offerLast(deq.pollFirst());
        }
        sb.append(deq.pollFirst()).append("\n");
    }

    private static void turnLeft(int k) {
        for (int i = 0; i < k-1; i++) {
            deq.offerFirst(deq.pollLast());
        }
        sb.append(deq.pollLast()).append("\n");
    }
}

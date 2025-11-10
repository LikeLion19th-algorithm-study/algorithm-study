package week05.boj2346;

import java.io.*;
import java.util.*;

public class 풍선터뜨리기_이해인 {
    static class Balloon {
        int index;
        int move;

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst(); // 맨 앞 풍선 터뜨리기
            sb.append(current.index).append(" ");

            if (deque.isEmpty()) break;

            int move = current.move;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    if (deque.isEmpty()) break; // npe 방지
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    if (deque.isEmpty()) break;
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}

package week05.boj2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기_심민아 {
    static class Balloon {
        int index;
        int value;

        Balloon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static Deque<Balloon> q = new ArrayDeque<>();

    public static void rotateRight(int K) {
        for (int i = 0; i < K - 1; i++) {
            q.offerLast(q.pollFirst());
        }
    }

    public static void rotateLeft(int K) {
        for (int i = 0; i < K ; i++) {
            q.offerFirst(q.pollLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            q.offer(new Balloon(i, value));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Balloon current = q.pollFirst();
            sb.append(current.index).append(" ");

            if (q.isEmpty()) break;

            int move = current.value;

            if (move > 0) {
                rotateRight(move);
            } else {
                rotateLeft(-move);
            }
        }

        System.out.println(sb.toString().trim());
    }
}
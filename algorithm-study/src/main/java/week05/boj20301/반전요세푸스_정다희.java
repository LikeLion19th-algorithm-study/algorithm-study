package week05.boj20301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 20301 반전 요세푸스
 * 메모리: 18032KB
 * 시간: 260ms
 *
 * @author dahee
 */
public class 반전요세푸스_정다희 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int totalPeople, stepSize, reverse, killCount;
    static boolean isReversed;

    public static void main(String[] args) throws IOException {
        init();
        killStart();
        System.out.println(sb.toString());
    }

    static void killStart() {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= totalPeople; i++) {
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            if (!isReversed) {
                for (int i = 0; i < stepSize - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
                sb.append(deque.removeFirst()).append("\n");
            } else {
                for (int i = 0; i < stepSize - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
                sb.append(deque.removeLast()).append("\n");
            }
            killCount++;
            applyReverseInterval();
        }
    }

    public static void applyReverseInterval () {
        if (reverse > 0 && killCount % reverse == 0) {
            isReversed = !isReversed;
        }
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        totalPeople = Integer.parseInt(st.nextToken());
        stepSize = Integer.parseInt(st.nextToken());
        reverse = Integer.parseInt(st.nextToken());
    }
}

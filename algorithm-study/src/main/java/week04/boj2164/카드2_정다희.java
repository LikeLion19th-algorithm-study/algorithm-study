package week04.boj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BOJ 2164 카드2
 * 메모리: 24060KB
 * 시간: 144ms
 *
 * @author dahee
 */
public class 카드2_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>(n);

        for (int i = 1; i <= n; i++) {
            q.addLast(i);
        }

        while (q.size() > 1) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }

        System.out.println(q.getFirst());
    }
}

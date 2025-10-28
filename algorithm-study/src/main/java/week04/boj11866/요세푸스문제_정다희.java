package week04.boj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 11866 요세푸스 문제 0
 * 메모리: 15248KB
 * 시간: 128ms
 *
 * @author dahee
 */
public class 요세푸스문제_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        sb.append("<");

        while(!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.addLast(queue.poll());
            }
            sb.append(queue.poll());
            sb.append(queue.isEmpty() ? ">" : ", ");
        }

        System.out.println(sb);
    }
}

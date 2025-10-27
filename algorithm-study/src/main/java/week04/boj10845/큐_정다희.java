package week04.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 10845 큐
 * 메모리: 18444KB
 * 시간: 156ms
 *
 * @author dahee
 */
public class 큐_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            boolean isQueueEmpty = queue.isEmpty();

            switch(s) {
                case "push":
                    queue.offer(x);
                    break;
                case "pop":
                    sb.append(isQueueEmpty ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(isQueueEmpty ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(isQueueEmpty ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(isQueueEmpty ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}

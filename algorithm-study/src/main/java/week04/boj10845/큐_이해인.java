package week04.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 큐_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                queue.offer(x);
            } else if (command.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            } else if (command.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
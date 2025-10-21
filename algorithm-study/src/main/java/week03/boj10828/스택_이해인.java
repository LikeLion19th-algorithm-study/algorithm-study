package week03.boj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                stack.push(num);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.pop()).append('\n');
            } else if (command.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("top")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}

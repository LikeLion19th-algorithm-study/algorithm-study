package main.java.week03.boj9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class 괄호_양민섭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            if (isVPS(ps)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    public static boolean isVPS(String ps) {
        Stack<Character> stack = new Stack<>();

        for (char ch : ps.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else { // ')'
                if (stack.isEmpty()) { // 더이상 pop할 '(' 없음
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 VPS
    }
}
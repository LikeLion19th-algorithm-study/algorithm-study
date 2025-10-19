package week03.boj9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 9012번 - 괄호
 * 주어진 괄호 문자열이 올바른 괄호(VPS)인지 판별하는 문제.
 *
 * 조건:
 * - '(' 와 ')' 의 개수가 같아야 하고
 * - 순회 중 ')' 가 '(' 보다 많아지면 안 된다.
 *
 * 풀이:
 * - '('일 때 push, ')'일 때 pop
 * - 중간에 pop 불가하면 NO
 * - 끝나고 스택이 비면 YES, 아니면 NO
 *
 * 메모리: 14372KB / 시간 : 108ms
 */
public class 괄호_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (Character c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (isValid && stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

package week03.boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}

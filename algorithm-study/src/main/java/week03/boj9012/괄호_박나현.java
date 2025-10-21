package week03.boj9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_박나현 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        Stack<Character> stack = null;
        String status = "";

        while (num-- > 0) {
            status = "YES";
            stack = new Stack<>();

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.empty()) {
                        status = "NO";
                        break;
                    } else stack.pop();
                }
            }
            if (!stack.empty()) status = "NO";
            sb.append(status).append("\n");
        }

        System.out.println(sb);
    }
}

package week03.boj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내기
 * VPS: 한 쌍의 괄호 기호로 된 "()" 문자열
 * 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력
 * <p>
 * 메모리: 14456KB / 시간: 104ms
 */
public class 괄호_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVps = true;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    stack.push(line.charAt(i));
                }
                if (line.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        isVps = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && isVps) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}

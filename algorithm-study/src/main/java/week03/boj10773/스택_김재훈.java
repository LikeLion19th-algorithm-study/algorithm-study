package week03.boj10773;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 명령은 총 다섯 가지이다.
 * <p>
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * <p>
 * 첫째 줄에 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 * <p>
 * 메모리: 19500KB / 시간: 160ms
 */
public class 스택_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken()); // 명령의 수

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine()); // 명령 읽기
            String command = st.nextToken();

            switch (command) {
                case "push": // 정수 X를 스택에 넣는 연산.
                    int num = Integer.parseInt(st.nextToken()); // 정수 X
                    stack.push(num);
                    break;
                case "pop": // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 만약 스택에 들어있는 정수가 없는 경우 -1을 출력.
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size": // 스택에 들어있는 정수의 개수를 출력.
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty": // 스택이 비어있으면 1, 아니면 0을 출력.
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top": // 스택의 가장 위에 있는 정수를 출력. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력.
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

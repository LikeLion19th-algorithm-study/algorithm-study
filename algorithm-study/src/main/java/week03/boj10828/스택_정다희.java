package week03.boj10828;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 10828번 - 스택
 * 정수를 저장하는 스택을 구현하고, 주어진 명령을 처리하는 문제.
 *
 * 명령어:
 * - push X : 정수 X를 스택에 넣는다.
 * - pop    : 스택의 맨 위 정수를 빼고 출력. 스택이 비어있으면 -1 출력.
 * - size   : 스택에 들어있는 정수의 개수 출력.
 * - empty  : 스택이 비어있으면 1, 아니면 0 출력.
 * - top    : 스택의 맨 위 정수를 출력. 스택이 비어있으면 -1 출력.
 *
 * 풀이:
 * - ArrayDeque를 이용해 스택 구현 (Stack보다 빠르고 가벼움)
 * - 각 명령어에 맞게 push/pop/peek/isEmpty 처리
 * - pop, top 시 스택이 비어 있으면 -1 출력
 *
 * 메모리: 19788KB / 시간 160 ms
 * (if문으로 풀었을 때 메모리: 19792 / 시간 168ms)
 */
public class 스택_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            int x = 0; // 입력 안하는 경우도 있어서 hasMoreToken 처리
            if (st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            // 그냥 반복되는 부분이라 깔끔하게 하려고 변수처리
            boolean isStackEmpty = stack.isEmpty();

            switch (s) {
                case "push":
                    stack.push(x);
                    break;
                case "pop":
                    sb.append(isStackEmpty? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(isStackEmpty ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(isStackEmpty ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

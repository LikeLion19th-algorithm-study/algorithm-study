package week03.boj10828;

import java.util.*;
import java.io.*;

public class 스택_심민아 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = -1;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push": {
                    int x = Integer.parseInt(st.nextToken());
                    stack[++top] = x;
                    break;
                }
                case "pop": {
                    if (top == -1) sb.append(-1).append('\n');
                    else sb.append(stack[top--]).append('\n');
                    break;
                }
                case "size": {
                    sb.append(top + 1).append('\n');
                    break;
                }
                case "empty": {
                    sb.append(top == -1 ? 1 : 0).append('\n');
                    break;
                }
                case "top": {
                    if (top == -1) sb.append(-1).append('\n');
                    else sb.append(stack[top]).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}
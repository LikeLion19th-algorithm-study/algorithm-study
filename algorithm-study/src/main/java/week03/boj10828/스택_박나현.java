package week03.boj10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_박나현 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int count = Integer.parseInt(st.nextToken());

        while (count --> 0) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    sb.append(stack.empty()? -1: stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()? 1:0).append("\n");
                    break;
                case "top":
                    sb.append(stack.empty()?-1:stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}

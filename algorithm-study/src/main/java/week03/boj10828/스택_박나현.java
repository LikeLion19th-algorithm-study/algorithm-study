package week03.boj10828;

import java.util.*;
import java.io.*;

public class 스택_박나현 {

    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        while (count --> 0) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    sb.append(empty()? -1: pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()? 1:0).append("\n");
                    break;
                case "top":
                    sb.append(empty()?-1:top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num) {
        list.add(num);
    }
    public static int pop() {
        int a = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return a;
    }
    public static int size() {
        return list.size();
    }
    public static boolean empty() {
        return list.isEmpty();
    }
    public static int top() {
        return list.get(list.size() - 1);
    }

    //    public static void main(String[] args) throws Exception {
    //        StringBuilder sb = new StringBuilder();
    //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //        StringTokenizer st = new StringTokenizer(br.readLine());
    //
    //        Stack<Integer> stack = new Stack<>();
    //
    //        int count = Integer.parseInt(st.nextToken());
    //
    //        while (count --> 0) {
    //            st = new StringTokenizer(br.readLine());
    //            String method = st.nextToken();
    //            switch (method) {
    //                case "push" :
    //                    int num = Integer.parseInt(st.nextToken());
    //                    stack.push(num);
    //                    break;
    //                case "pop":
    //                    sb.append(stack.empty()? -1: stack.pop()).append("\n");
    //                    break;
    //                case "size":
    //                    sb.append(stack.size()).append("\n");
    //                    break;
    //                case "empty":
    //                    sb.append(stack.empty()? 1:0).append("\n");
    //                    break;
    //                case "top":
    //                    sb.append(stack.empty()?-1:stack.peek()).append("\n");
    //                    break;
    //            }
    //        }
    //
    //        System.out.println(sb);
    //    }
}

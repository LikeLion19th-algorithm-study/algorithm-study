package week04.boj10845;

import java.io.*;
import java.util.*;

// 메모리: 20052KB, 시간: 164ms
public class 큐_박나현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        int count = Integer.parseInt(st.nextToken());
        int last = -1;

        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            switch (method) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    last = num;
                    q.offer(num);
                    break;
                case "pop":
                    sb.append(q.isEmpty()? -1: q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty()? 1:0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty()?-1:q.peek()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty()?-1:last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
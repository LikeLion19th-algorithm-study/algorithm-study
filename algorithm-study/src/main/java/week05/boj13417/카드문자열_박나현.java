package week05.boj13417;

import java.util.*;
import java.io.*;

public class 카드문자열_박나현 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int count = Integer.parseInt(st.nextToken());

        while (count-- > 0) {

            Deque<String> deq = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            while (length-- > 0) {
                String c = st.nextToken();
                if (deq.isEmpty()) {
                    deq.offer(c);
                    continue;
                }
                if (c.compareTo(deq.peekFirst()) > 0) deq.offerLast(c);
                else deq.offerFirst(c);
            }

            while (!deq.isEmpty()) {
                sb.append(deq.poll());
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}

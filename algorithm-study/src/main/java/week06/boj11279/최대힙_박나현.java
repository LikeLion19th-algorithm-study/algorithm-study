package week06.boj11279;

import java.util.*;
import java.io.*;

public class 최대힙_박나현 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else pq.offer(n);
        }
        System.out.println(sb);
    }
}

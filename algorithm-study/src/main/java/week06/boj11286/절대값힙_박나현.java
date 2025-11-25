package week06.boj11286;

import java.io.*;
import java.util.*;

public class 절대값힙_박나현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            } else return Math.abs(a) - Math.abs(b);
        }
        );

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(n);
            }
        }
        System.out.println(sb);
    }
}

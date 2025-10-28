package main.java.week04.boj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스문제_양민섭 {
    //22768 KB
    //136 ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        int count = 1;
        while (!queue.isEmpty()) {
            if (count % K == 0) {
                sb.append(queue.poll());
                count = 0;
                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                queue.add(queue.poll());
            }
            count++;
        }
        sb.append(">");
        System.out.println(sb);
    }
}

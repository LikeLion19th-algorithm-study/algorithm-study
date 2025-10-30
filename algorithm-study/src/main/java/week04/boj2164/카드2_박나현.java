package week04.boj2164;

import java.io.*;
import java.util.*;

public class 카드2_박나현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= num ; i++) {
            q.offer(i);
        }

        while (num-- > 1) {
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}

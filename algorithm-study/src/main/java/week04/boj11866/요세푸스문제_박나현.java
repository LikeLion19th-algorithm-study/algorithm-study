package week04.boj11866;

import java.io.*;
import java.util.*;

public class 요세푸스문제_박나현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= N ; i++) {
            q.offer(i);
        }

        sb.append('<');
        while(!q.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K-1) {
                    if (q.size() == 1) {
                        sb.append(q.poll());
                    } else {
                        sb.append(q.poll() + ", ");
                    }
                } else {
                    q.add(q.poll());
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}

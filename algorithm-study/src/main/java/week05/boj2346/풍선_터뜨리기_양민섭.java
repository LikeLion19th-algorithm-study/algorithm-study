package main.java.week05.boj2346;

import java.io.*;
import java.util.*;

public class 풍선_터뜨리기_양민섭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        // [번호, 이동값]
        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            dq.addLast(new int[]{i, move});
        }

        StringBuilder sb = new StringBuilder();

        int[] current = dq.pollFirst(); // 첫 풍선 터뜨리기
        sb.append(current[0]).append(' ');

        while (!dq.isEmpty()) {
            int move = current[1];

            if (move > 0) {
                // 오른쪽(앞)으로 move-1번 회전
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
                current = dq.pollFirst();
            } else {
                // 왼쪽(뒤)으로 |move|-1번 회전
                for (int i = 0; i < (-move) - 1; i++) {
                    dq.addFirst(dq.pollLast());
                }
                current = dq.pollLast();
            }

            sb.append(current[0]).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}

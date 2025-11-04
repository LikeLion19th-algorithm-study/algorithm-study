package main.java.week05.boj20301;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 반전_요세푸스_양민섭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 사람들을 1..N까지 넣어둔다
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        StringBuilder out = new StringBuilder();

        boolean clockwise = true; // 처음엔 오른쪽(시계 방향)으로 돈다
        int removed = 0;          // 지금까지 제거된 사람 수

        while (!circle.isEmpty()) {
            if (clockwise) {
                // 시계 방향: K-1번 앞에서 빼서 뒤에 붙인다
                for (int i = 0; i < K - 1; i++) {
                    int x = circle.removeFirst();
                    circle.addLast(x);
                }
                // K번째를 제거
                int dead = circle.removeFirst();
                out.append(dead).append('\n');
            } else {
                // 반시계 방향: K-1번 뒤에서 빼서 앞에 붙인다
                for (int i = 0; i < K - 1; i++) {
                    int x = circle.removeLast();
                    circle.addFirst(x);
                }
                // K번째를 제거 (반시계라서 뒤에서 제거)
                int dead = circle.removeLast();
                out.append(dead).append('\n');
            }

            removed++;

            // M명 제거될 때마다 방향을 뒤집는다
            if (removed % M == 0) {
                clockwise = !clockwise;
            }
        }

        System.out.print(out.toString());
    }
}

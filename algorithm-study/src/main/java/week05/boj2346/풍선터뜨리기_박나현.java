package week05.boj2346;

import java.util.*;
import java.io.*;

// 원형으로 놓인 풍선들을 터뜨리며, 각 풍선에 적힌 숫자만큼 왼쪽 또는 오른쪽으로 이동해 다음 풍선을 터뜨린다.
// 메모리: 15564KB | 시간: 164ms
public class 풍선터뜨리기_박나현 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 덱에 [풍선 번호, 종이에 적힌 수] 배열로 저장
        Deque<int[]> deq = new ArrayDeque<>();

        // 덱에 저장할 갯수
        int size = Integer.parseInt(br.readLine());

        // 풍선 숫자를 차례대로 읽고 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            int n = Integer.parseInt(st.nextToken());
            deq.offer(new int[]{i, n});
        }

        // 먼저 첫번째 풍선을 터뜨리고
        int[] first = deq.pollFirst();
        sb.append(first[0]).append(" ");

        // 첫번째 풍선의 숫자 저장
        int next = first[1];

        while (!deq.isEmpty()) {
            // 풍선의 숫자만큼 옆으로 감
            // 양수면 오른쪽, 음수면 왼쪽으로
            if (next > 0) {
                for (int j = 0; j < next-1; j++) {
                    deq.offerLast(deq.poll());
                }
            } else {
                for (int j = 0; j < Math.abs(next); j++) {
                    deq.offerFirst(deq.pollLast());
                }
            }

            // 돌려서 나온 풍선을 터뜨림
            first = deq.poll();
            sb.append(first[0]).append(" ");
            next = first[1];

            //반복
        }
        System.out.println(sb);
    }
}

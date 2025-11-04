package week05.boj2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 2346 풍선 터뜨리기
 * 메모리: 14560KB
 * 시간: 152ms
 *
 * @author dahee
 */
public class 풍선터뜨리기_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            deque.offer(i+1);
        }

        while(!deque.isEmpty()) {
            int idx = deque.pollFirst(); // 처음 1번 풍선 뺌
            sb.append(idx).append(" ");

            int move = arr[idx - 1]; // idx 0부터 시작
            if (deque.isEmpty()) break; // deque가 비었으면 그냥 멈춤

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.offerLast(deque.pollFirst()); // 맨앞에꺼 빼서 맨뒤로 보냄 - 왼쪽 회전
                }
            } else {
                for (int j = 0; j < Math.abs(move); j++) {
                    deque.offerFirst(deque.pollLast()); // 맨뒤에꺼 빼서 앞으로 보냄 - 오른쪽 회전
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}

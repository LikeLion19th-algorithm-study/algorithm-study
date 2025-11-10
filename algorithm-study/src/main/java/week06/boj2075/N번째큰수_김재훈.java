package week06.boj2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N개의 줄에 각 줄마다 N개의 수가 주어지는 표
 * N번째 큰 수를 찾는 프로그램
 * 메모리: 243272KB | 시간: 796ms
 */
public class N번째큰수_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine()); // 주어진 숫자 N
        int result;

        StringTokenizer st;
        for (int i = 0; i < n; i++) { // 표 채우기
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        while (n-- > 1) { // N번째 큰 수를 구해야하므로, N-1 까지 반복
            pq.poll();
        }

        result = pq.poll();
        System.out.println(result);
    }
}

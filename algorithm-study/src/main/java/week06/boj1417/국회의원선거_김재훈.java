package week06.boj1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 다솜이가 다른 모든 사람의 득표수보다 많은 득표수를 갖도록 만드는 문제
 * 메모리: 14384KB | 시간: 104ms
 */
public class 국회의원선거_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine()); // 후보의 수 N
        int dasom = Integer.parseInt(br.readLine());
        int count = 0;

        while (n-- > 1) { // 다솜이 숫자를 제외하고 넣으므로 0이 될 때까지가 아닌, 1이 될 떄까지 반복
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty() && pq.peek() >= dasom) {
            // 큐가 비어있지 않으며, 첫 번째 값이 다솜이 숫자보다 작을 때까지 반복
            // 이렇게 하면 큐가 비었을 때는 while문을 시도조차 하지 않게 된다.
            // 둘의 순서를 바꾸면 pq.peek() 에서 NPE가 발생한다.

            pq.offer(pq.poll() - 1); // 표가 가장 많은 사람에게서 한 표를 뺏는다.
            dasom++; // 뺏은 한 표를 다솜이가 갖는다.
            count++; // 반복 횟수 증가
        }

        System.out.println(count);
    }
}

package week06.boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 *
 * 1. 배열에 정수 x (x ≠ 0)를 넣는다.
 * 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *    절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 *
 * // 절댓값이 작은 수가 우선: |a| < |b| => a
 * // 절댓값이 같다면 실제 값이 작은 수(음수 우선)를 먼저 꺼내도록 하는 우선순위 큐: (|a| == |b|) => (a < b) => a
 *
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 *
 * 입력에서 0이 주어진 회수만큼 답을 출력한다.
 * 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 */

public class 절대값힙_이해인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        /*
        * Comparator: 우선순위큐가 어떤 기준으로 정렬될지, 우선순위를 정하는 기준
        * (a, b) -> {
        *    // a가 b보다 먼저 나와야 하면 음수 반환
        *    // 같으면 0 반환
        *    // b가 먼저 나와야 하면 양수 반환
        *    return 비교결과;
        * }
        *
        * compare(a, b) < 0: a가 b보다 우선순위가 높다 (힙 위로 올라간다)
        * compare(a, b) == 0: 둘이 동일하다고 본다
        * compare(a, b) > 0: b가 a보다 우선순위가 높다
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            // 1. 절대값 오름차순 비교
            if (absA != absB) {
                return Integer.compare(absA, absB); // 우선순위 결정
            }

            // 2. 실제 값 오름차순 비교 (음수가 양수보다 먼저 나오도록)
            return Integer.compare(a, b);

            // if (absA == absB) {
            //     return a - b; // 오버플로우 발생 가능
            // }
            // return absA - absB;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            // x가 0인 경우: 힙이 비어 있으면 0, 아니면 조건에 맞는 값 하나 꺼내서(poll) 출력
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n'); // 절댓값 기준으로 가장 작은 값(여러 개면 실제 값이 가장 작은 수)을 꺼내서 출력
                }
            } else {
                pq.offer(x); // x가 0이 아닌 경우: (절댓)값 기준에 따라 우선순위 큐에 추가
            }
        }

        System.out.print(sb);
    }
}

// 메모리: 25588 KB
// 시간: 288 ms
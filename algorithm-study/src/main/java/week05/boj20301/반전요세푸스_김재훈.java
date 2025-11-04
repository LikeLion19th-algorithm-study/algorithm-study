package week05.boj20301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 지난주 풀었던 기존 요세푸스 문제
 * 원을 이룬 N명의 사람들
 * K번 사람 제거 후 오른쪽의 K번째 사람 계속해서 제거
 * (7, 3)-요세푸스 순열: <3, 6, 2, 7, 5, 1, 4>
 * <p>
 * 이번주 반전 요세푸스 문제
 * M명의 사람이 제거될 때마다 원을 돌리는 방향을 바꾼다.
 * (7, 3, 4)-반전 요세푸스 순열: <3, 6, 2, 7, 1, 5, 4>
 * <p>
 * 반복문<-> 조건문 수정 전 - 메모리: 19460KB / 시간: 328ms
 */
public class 반전요세푸스_김재훈 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 총 N명의 사람
        int k = Integer.parseInt(st.nextToken()); // 계속해서 제거할 K번째 사람
        int m = Integer.parseInt(st.nextToken()); // 방향을 바꾸는 기준이 되는 M명의 사람
        int count = 0; // 반복문 내에서 M을 판별하기 위한 변수
        boolean flag = true; // 방향을 바꿔주기 위한 flag, true = 정방향, false = 역방향

        initDeque(n); // N명의 사람 번호 순서대로 나열

        while (!deque.isEmpty()) {
            if (flag) {
                repeatForward(k); // 정방향 반복
            } else {
                repeatReverse(k); // 역방향 반복
            }

/*
            // 반복문 내에서 조건문 도는 것보다 조건문 내에서 반복문 도는 것이 빠르다.
            for (int i = 0; i < k - 1; i++) {
                if (flag) {
                    deque.offerLast(deque.pollFirst()); // 정방향, 앞 사람을 뒤로 보내기
                } else {
                    deque.offerFirst(deque.pollLast()); // 역방향, 뒷 사람을 앞으로 보내기
                }
            }
*/

            count++; // 한 명을 추가할 때마다 1씩 증가한다.

            if (count % m == 0) { // 나눴을 때 0이 되면 M의 배수
                flag = !flag;
            }
        }
        System.out.println(sb);
    }

    private static void initDeque(int n) {
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
    }

    private static void repeatForward(int k) {
        for (int i = 0; i < k - 1; i++) {
            deque.offerLast(deque.pollFirst()); // 정방향, 앞 사람을 뒤로 보내기
        }
        sb.append(deque.pollFirst()).append("\n");
    }

    private static void repeatReverse(int k) {
        for (int i = 0; i < k - 1; i++) {
            deque.offerFirst(deque.pollLast()); // 역방향, 뒷 사람을 앞으로 보내기
        }
        sb.append(deque.pollLast()).append("\n");
    }
}

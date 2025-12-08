package week07.boj11729;

import java.io.*;

/**
 * 메모리 71224KB,  시간 452ms
 * 하노이탑은 3개의 기둥과 여러 개의 원판으로 이루어져 있고, 규칙은 두 가지이다
 * 첫째, 한 번에 한 개씩만 옮길 수 있다
 * 둘째, 큰 원판을 작은 원판 위에 놓을 수 없다
 */
public class 하노이탑_박나현 {

    // 이동 기록을 저장할 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사용자로부터 원판 개수 입력
        int n = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, n) - 1).append("\n");
        // 하노이탑 시작: 1번 기둥 → 3번 기둥, 2번 기둥은 임시
        hanoi(n, 1, 2, 3);
        // 이동 순서 출력
        System.out.println(sb);
    }

    /**
     * n개의 원판을 from 기둥에서 to 기둥으로 옮기는 재귀 함수
     *
     * !! 큰 원판을 옮기려면 위에 있는 n-1개의 작은 원판을 먼저 다른 기둥으로 옮겨야 함 !!
     *
     * 1단계: n-1개의 원판을 from → temp로 이동
     *        (예: 4번 원판을 옮기려면 1,2,3을 다른 기둥으로 먼저 이동)
     *
     * 2단계: 가장 큰 원판 1개를 from → to로 이동
     *
     * 3단계: n-1개의 원판을 temp → to로 이동
     *        (위에서 옮긴 작은 원판들을 큰 원판 위로 다시 이동)
     */
    private static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            // 원판 1개는 바로 이동
            sb.append(from + " " + to + "\n");
        } else {
            // 1단계: n-1개의 원판을 임시 기둥으로 이동
            hanoi(n - 1, from, to, temp);

            // 2단계: 가장 큰 원판 이동
            sb.append(from + " " + to + "\n");

            // 3단계: n-1개의 원판을 목적지 기둥으로 이동
            hanoi(n - 1, temp, from, to);
        }
    }
}

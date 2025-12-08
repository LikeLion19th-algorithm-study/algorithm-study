package week07.boj11729;

import java.io.*;

public class 하노이탑_박나현 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, n) - 1).append("\n");
        // 하노이탑 시작: 1번 기둥 → 3번 기둥, 2번 기둥은 임시
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            sb.append(from + " " + to +"\n");
        } else {
            hanoi(n - 1, from, to, temp);
            sb.append(from + " " + to+"\n");
            hanoi(n - 1, temp, from, to);
        }
    }
}

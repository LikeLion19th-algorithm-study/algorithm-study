package week07.boj11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11729
 * 메모리: KB
 * 시간: ms
 * - 백준에 제출 안함
 *
 * @author dahee
 */
public class 하노이탑_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = (int)Math.pow(2, n) - 1;
        System.out.println(count);
        hanoi(n, 1, 3, 2);
    }

    public static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        hanoi(n-1, from, aux, to);
        System.out.println(from + " " + to);
        hanoi(n-1, aux, to, from);
    }
}

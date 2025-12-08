package week07.boj10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫째 줄에 n이 주어진다. n번째 피보나치 수를 출력한다.
 * 메모리: 14356KB | 시간: 100ms
 */
public class 피보나치수5_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 주어진 수 n
        int result = fibonacci(n);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        // 0번째 피보나치 수는 0, 1번째 피보나치 수는 1
        // 그 다음 2번째부터는 바로 앞 두 피보나치 수의 합이 된다.
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

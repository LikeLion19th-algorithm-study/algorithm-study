package week01.boj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 수행시간: 104ms
 */
public class 소수찾기_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(split[i]);
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;

        // 2를 판별하지 않게 되므로 2는 수동으로 true 반환
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}

package week01.boj9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 */
public class 골드바흐의추측_김재훈 {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // 짝수가 주어지므로 반으로 나눈 값에서 찾아가기
            int i1 = n / 2;
            int i2 = n / 2;

            boolean[] prime = findPrime(n);

            while (true) {
                if (prime[i1] && prime[i2]) {
                    System.out.println(i1 + " " + i2);
                    break;
                }
                i1--;
                i2++;
            }
        }
    }

    private static boolean[] findPrime(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니다.

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}

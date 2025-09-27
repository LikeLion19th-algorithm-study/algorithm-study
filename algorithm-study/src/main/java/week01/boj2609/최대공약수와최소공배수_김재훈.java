package week01.boj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * 최대공약수(GCD) 공식 예) gcd(48, 18) = 12 -> gcd(18, 12) = 6 -> gcd(12, 6) = 0 => 최대공약수 6
 * 최소공배수(LCM) 공식 a * b / gcd(a, b) 예) lcm(48,18) = 48 * 18 / 6 = 144
 */
public class 최대공약수와최소공배수_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        // b가 더 큰 수일 경우 순서 교체
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        int gcd = gcd(a, b);
        int lcn = lcn(a, b);

        System.out.println(gcd);
        System.out.println(lcn);
    }

    // 최대 공약수
    static int gcd(int a, int b) {
        // 나누었을 때 0이 되는 값이 최대 공약수
        if (a % b == 0) {
            return b;
        }

        // 재귀 호출
        return gcd(b, a % b);
    }

    // 최소 공배수
    static int lcn(int a, int b) {
        return a * b / gcd(a, b);
    }
}

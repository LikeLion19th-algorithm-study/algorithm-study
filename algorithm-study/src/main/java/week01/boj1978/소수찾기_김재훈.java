package week01.boj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
public class 소수찾기_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 활용 x
        String[] split = br.readLine().split(" ");
        int count = 0;

        for (String s : split) {
            int num = Integer.parseInt(s);
            boolean isPrime = true;

            // 0과 1은 소수가 아니므로 통과
            if (num == 0 || num == 1) {
                continue;
            }

            // 2부터 (자기 숫자 -1)까지 나눠봤을 때 나눠지는 수가 없어야 소수
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }
        System.out.println(count);
    }
}

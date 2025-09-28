package week01.boj1978;

import java.util.Scanner;

public class 소수찾기_박나현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < num; i++) {
            int number = sc.nextInt();
            if (isPrime(number)) count++;
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        else if (n == 2) return true;
        else {
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) return false;
            }
        }
        return true;
    }
}

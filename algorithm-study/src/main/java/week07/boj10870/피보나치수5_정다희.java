package week07.boj10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10870
 * 메모리: 14064KB
 * 시간: 108ms
 *
 * @author dahee
 */
public class 피보나치수5_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return (fibo(n-1) + fibo(n-2));
    }
}

package week01.boj9020;

import java.io.*;
import java.util.*;

public class 골드바흐의추측_심민아 {

    static boolean[] sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime,true); //소수가 맞는지 판별하는 isPrime배열에 처음엔 다 true로 채워넣기
        isPrime[0] =isPrime[1]=false; //0,1은 소수가 아니니까 false

        for (int p = 2; p * p <= max; p++) { //에라토스테네스의 체 방식으로 max까지 소수가 맞는 지 확인
            if (isPrime[p]) {
                for (int m = p * p; m <= max; m += p) {
                    isPrime[m] = false; //소수가 아니라면 false
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        int[] nums = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            nums[i] = n;
            if (n > max) max = n;
        }

        boolean[] isPrime = sieve(max);

        for (int n : nums) {
            int a = n / 2, b = n / 2;
            while (a >= 2) {
                if (isPrime[a] && isPrime[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--; b++;
            }
        }
    }
}

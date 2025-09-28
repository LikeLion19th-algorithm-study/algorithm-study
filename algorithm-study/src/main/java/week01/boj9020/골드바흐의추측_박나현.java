package week01.boj9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측_박나현 {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] nums = new int[count];
        int max = 0;

        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        sieve(max);

        for (int i = 0; i < count; i++) {
            int n  = nums[i];
            int p = getSmallPrime(n);
            sb.append(p).append(" ").append(n - p).append("\n");
        }
        System.out.println(sb);
    }

    private static void sieve(int n) {
        isPrime = new boolean[n+1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for(int j = i*i; j<= n; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
    }

    private static int getSmallPrime(int n) {
        for (int i = n/2; i >= 2; i--) {
            if (isPrime[i] && isPrime[n-i]){
                return i;
            }
        }
        return 2;
    }
}

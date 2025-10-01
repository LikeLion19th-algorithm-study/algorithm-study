package week01.boj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수찾기_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 1000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrime[num]) count++;
        }

        System.out.println(count);
    }
}

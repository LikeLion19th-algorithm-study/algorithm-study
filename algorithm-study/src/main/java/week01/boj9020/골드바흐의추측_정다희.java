package week01.boj9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 골드바흐의추측_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 10000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a = n / 2;
            int b = n / 2;

            while(true) {
                if (isPrime[a] && isPrime[b]) {
                    sb.append(a).append(" ").append(b).append("\n");
                    break;
                }
                a--; b++;
            }
        }

        System.out.println(sb);
    }
}

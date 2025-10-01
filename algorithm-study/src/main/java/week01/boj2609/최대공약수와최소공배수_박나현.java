package week01.boj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수_박나현 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        System.out.println(gcd(n,m));
        System.out.println(lcm(n,m));
    }
    private static long gcd(long n, long m) {
        long q = n / m;
        long r = n % m;

        if (r == 0) {
            return m;
        } else {
            n = m;
            m = r;
            return gcd(n, m);
        }
    }
    private static long lcm(long n, long m) {
        return (n * m) / gcd(n,m);
    }
}

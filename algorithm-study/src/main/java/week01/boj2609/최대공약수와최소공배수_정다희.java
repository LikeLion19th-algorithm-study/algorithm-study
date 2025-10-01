package week01.boj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int x = a, y = b;

        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        int gcd = x;
        long lcm = (long) (a / gcd) * b;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}

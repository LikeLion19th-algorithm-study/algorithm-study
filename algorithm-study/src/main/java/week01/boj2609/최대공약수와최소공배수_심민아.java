package week01.boj2609;

import java.util.Scanner;


public class 최대공약수와최소공배수_심민아 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
    static int gcd(int a, int b) { //최대공약수
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) { //최소공배수
        return a * b / gcd(a, b);
    }
}

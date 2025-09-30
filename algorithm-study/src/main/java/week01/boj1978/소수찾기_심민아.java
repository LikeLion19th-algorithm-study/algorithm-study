package week01.boj1978;

import java.util.Arrays;
import java.util.Scanner;

public class 소수찾기_심민아 {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //N개의 수 받기
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) { //N개의 수만큼 입력 받아서 배열에 저장
            arr[i] = sc.nextInt();
            if (arr[i] > max) max = arr[i]; //입력 받으면서 가장 큰 수 찾기(가장 큰 수까지 소수가 맞는 지 검사하려고)
        }

        boolean[] isPrime = sieve(max);

        int count = 0;
        for (int x : arr) {
            if (isPrime[x]) count++; //isPrime 배열 확인해서 true라면 소수이므로 count +1하기
        }
        System.out.println(count);
    }
}
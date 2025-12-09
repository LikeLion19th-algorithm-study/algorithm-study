package week08.boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기2_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr= new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        //Stringbuilder 안쓰고 바로 출력하려고 했으나 시간초과
        //println은 매번 많은 flush 발생
//        for(int i = 0; i < N; i++) {
//            System.out.println(arr[i]);
//        }
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

}

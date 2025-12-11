package week08.boj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[][] arr=new String[N][2];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" "); // input->21 Junkyu
            arr[i][0] = input[0]; //21
            arr[i][1] = input[1]; //Junkyu
        }

        Arrays.sort(arr, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        for(String[] p: arr){
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.println(sb);
    }
}

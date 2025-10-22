package week3.boj10828;

import java.io.*;
import java.util.*;

public class 제로_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

//        for(int i = 0; i < K; i++){
//            int num = Integer.parseInt(br.readLine());
//
//            if(num==0){
//                stack.pop();
//            }
//            else{
//                stack.push(num);
//            }
//        }
//        int sum=0;
//        for(int num:stack){
//            sum+=num;
//        }

        //스택에 pop,push 하면서 동시에 sum까지 구하는 방식
        int sum = 0;
        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                sum -= stack.pop();
            }
            else{
                stack.push(num);
                sum += num;
            }
        }

        System.out.println(sum);
    }
}

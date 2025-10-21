package week03.boj10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_박나현 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack =  new Stack<>();

        while (count-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}

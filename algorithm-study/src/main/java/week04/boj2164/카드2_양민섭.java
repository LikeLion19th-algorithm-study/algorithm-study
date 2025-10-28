package main.java.week04.boj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_양민섭 {
    //메모리 : 45500KB
    //시간 : 160ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll(); // 맨 위 카드 버리기
            queue.offer(queue.poll()); // 맨 위 카드 맨 아래 삽입
        }
        System.out.println(queue.peek());
    }
}

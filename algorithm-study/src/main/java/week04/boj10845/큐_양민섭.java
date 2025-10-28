package main.java.week04.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class 큐_양민섭 {
    //메모리 : 20828KB
    //시간 : 168 ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String command = br.readLine();

            if(command.startsWith("push")){
                int x = parseInt(command.split(" ")[1]);
                pushX(queue, x);
            }
            else if(command.equals("pop")){
                sb.append(pop(queue)).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(size(queue)).append("\n");
            }
            else if(command.equals("empty")) {
                sb.append(empty(queue)).append("\n");
            }
            else if(command.equals("front")){
                sb.append(front(queue)).append("\n");
            }
            else if(command.equals("back")){
                sb.append(back(queue)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void pushX(Queue<Integer> queue, int x) {
        queue.offer(x);
    }

    public static int pop(Queue<Integer> queue){
        if(queue.isEmpty()) return -1;
        return queue.poll();
    }

    public static int size(Queue<Integer> queue){
        return queue.size();
    }

    public static int empty(Queue<Integer> queue){
        if(queue.isEmpty()) return 1;
        return 0;
    }

    public static int front(Queue<Integer> queue){
        if(queue.isEmpty()) return -1;
        return queue.peek();
    }

    public static int back(Queue<Integer> queue){
        if(queue.isEmpty()) return -1;

        Queue<Integer> queue2 = new LinkedList<>(queue);
        while(queue2.size() > 1){
            queue2.poll();
        }
        return queue2.peek();
    }
}

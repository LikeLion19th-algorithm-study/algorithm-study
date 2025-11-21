package week06.boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절대값힙_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);

                    // 절댓값이 다르면 절댓값 작은 게 먼저
                    if (absA != absB) {
                        return absA - absB;
                    }
                    // 절댓값이 같다면 실제 값이 작은 게 먼저
                    return a - b;
                }
        );
        while(N-->0){
            int x=Integer.parseInt(st.nextToken());
            if(x==0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}

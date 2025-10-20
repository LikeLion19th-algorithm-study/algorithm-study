package week02.boj1764;

import java.io.*;
import java.util.*;

public class 듣보잡_심민아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>(N);
        for(int i = 0; i < N; i++){
            unheard.add(br.readLine());
        }
        Set<String> unsee = new HashSet<>(M);
        for(int i = 0; i < M; i++){
            unsee.add(br.readLine());
        }

        unheard.retainAll(unsee);

        List<String> result = new ArrayList<>(unheard);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for(String name : result){
            sb.append(name).append('\n');
        }
        System.out.print(sb);
    }
}

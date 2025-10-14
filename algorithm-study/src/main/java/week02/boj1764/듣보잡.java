package week02.boj1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> neverHeard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            neverHeard.add(s);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String neverSeen = br.readLine();
            if (neverHeard.contains(neverSeen)) {
                result.add(neverSeen);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}

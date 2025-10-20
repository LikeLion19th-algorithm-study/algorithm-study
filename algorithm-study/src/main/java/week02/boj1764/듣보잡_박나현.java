package week02.boj1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_박나현 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> arr = new ArrayList<>();

        while (N -- > 0) {
            set.add(br.readLine());
        }

        while (M --> 0) {
            String str = br.readLine();
            if(set.contains(str)) arr.add(str);
        }

        Collections.sort(arr);

        int count = arr.size();
        sb.append(count).append("\n");

        for (int i = 0; i < count; i++) {
            sb.append(arr.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}

package week02.boj17219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기_박나현 {
    public static void main(String[] args) throws Exception {
        Map<String, String> hashMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사이트 개수, 찾을 개수
        int save = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());

        while (save --> 0) {
            st = new StringTokenizer(br.readLine());
            hashMap.put(st.nextToken(), st.nextToken());
        }

        while (find --> 0) {
            sb.append(hashMap.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}

package week02.boj17219;
import java.io.*;
import java.util.*;
public class 비밀번호찾기_심민아 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            map.put(site, pwd);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            sb.append(map.get(query)).append('\n');
        }

        System.out.print(sb.toString());
    }
}

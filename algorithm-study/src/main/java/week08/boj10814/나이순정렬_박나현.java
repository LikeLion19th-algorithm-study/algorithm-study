package week08.boj10814;

import java.io.*;
import java.util.*;

public class 나이순정렬_박나현 {
    static class Member {
        int index;
        int age;
        String name;

        Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            Member m = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
            members[i] = m;
        }

        Arrays.sort(members, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.index - o2.index;
            }
            return o1.age - o2.age;
        });

        for (Member member : members) {
            sb.append(member.toString()).append("\n");
        }

        System.out.println(sb);
    }
}

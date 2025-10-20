package week02.pgs42576;
import java.util.*;
import java.io.*;

public class 완주하지못한선수_심민아 {
    public static void main(String[] args) throws Exception {
        Solution s = new 완주하지못한선수_심민아().new Solution();

        System.out.println(s.solution(
                new String[]{"leo","kiki","eden"},
                new String[]{"eden","kiki"}
        ));

        System.out.println(s.solution(
                new String[]{"marina","josipa","nikola","vinko","filipa"},
                new String[]{"josipa","filipa","marina","nikola"}
        ));

        System.out.println(s.solution(
                new String[]{"mislav","stanko","mislav","ana"},
                new String[]{"stanko","ana","mislav"}
        ));
    }

    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();

            for(String name : participant) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }

            for(String name : completion) {
                map.put(name, map.get(name) - 1);
            }

            for(String key : map.keySet()) {
                if(map.get(key) != 0) {
                    return key;
                }
            }

            return "";
        }
    }
}
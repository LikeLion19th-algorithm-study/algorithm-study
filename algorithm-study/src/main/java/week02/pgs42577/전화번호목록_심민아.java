package week02.pgs42577;
import java.util.*;
import java.io.*;
public class 전화번호목록_심민아 {
    public static void main(String[] args) throws Exception {
        Solution s = new 전화번호목록_심민아().new Solution();

        System.out.println(s.solution(new String[]{"119","97674223","1195524421"}));
        System.out.println(s.solution(new String[]{"123","456","789"}));
        System.out.println(s.solution(new String[]{"12","123","1235","567","88"}));
    }

    class Solution {
        public boolean solution(String[] phone_book) {
            Map<String, Boolean> map = new HashMap<>();

            for (String phone : phone_book) {
                map.put(phone, true);
            }

            for (String phone : phone_book) {
                for (int i = 1; i < phone.length(); i++) {
                    if (map.containsKey(phone.substring(0, i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}

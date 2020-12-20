package removeDuplicateLetters;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/12/20 上午9:59
 */
public class Solution {

    public String removeDuplicateLetters(String s) {
        char[] c= s.toCharArray();
//        Map<Character, List<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>(List.of(i)));
        }
        for (int i = 0; i < c.length; i++) {
            int idx = c[i] - 'a';
            list.get(idx).add(i);
        }

        list.sort((a, b) -> {
            if (a.size() == 1) return 1;
            else if (b.size() == 1) return -1;
            else {
                if (a.get(0) < b.get(0)) {
                    for (int i = 1; i < b.size(); i++) {
                        if (b.get(i) > a.get(1)) return -1;
                    }
                    return 1;
                }
                else {
                    for (int i = 1; i < a.size(); i++) {
                        if (a.get(i) > b.get(1)) return 1;
                    }
                    return -1;
                }
            }
        });
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> l : list) {
            if (l.size() > 1) {
                sb.append((char)(l.get(0) + 'a'));
            }
        }

        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
}
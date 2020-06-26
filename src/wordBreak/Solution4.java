package wordBreak;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/25
 */
public class Solution4 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = new HashMap<>();
        char[] seq = s.toCharArray();
        for (String s1 : wordDict) {
            Character f = s1.charAt(0);
            if (!map.containsKey(f)){
                List<String> l = new ArrayList<>();
                l.add(s1);
                map.put(f, l);
            }else{
                map.get(f).add(s1);
            }
        }
        boolean[] step = new boolean[seq.length + 1];
        step[0] = true;
        for (int i = 0; i < seq.length ; i++) {
            if (step[i] && map.containsKey(seq[i])){
                for (String s1 : map.get(seq[i])) {
                    if (isMatch(seq, s1, i)) {
                        if (i+s1.length() == seq.length) return true;
                        step[i+s1.length()] = true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMatch (char[] seq, String s, int start) {
        if (start + s.length() > seq.length) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != seq[start+i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(List.of(new String[]{"leet", "code"}));
        System.out.println(wordBreak(s, wordDict));
    }

}

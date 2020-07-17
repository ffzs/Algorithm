package wordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ffzs
 * @describe
 * @date 2020/6/25
 */
public class Solution {
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
        System.out.println(map);
        return wordBreak(seq, 0, map);
    }

    public static boolean wordBreak (char[] seq, int start, Map<Character, List<String>> map) {
        if (start == seq.length) return true;
        if (!map.containsKey(seq[start])) return false;
        else {
            for (String s1 : map.get(seq[start])) {
                if (isMatch(seq, s1, start) && wordBreak(seq, start+s1.length(), map)) {
                    return true;
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

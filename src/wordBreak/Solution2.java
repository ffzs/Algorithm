package wordBreak;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/25
 */
public class Solution2 {
    static int max = 0, min = Integer.MAX_VALUE;
    public static boolean wordDict(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String s1 : wordDict) {
            wordSet.add(s1);
            max = Math.max(max, s1.length());
            min = Math.min(min, s1.length());
        }
        return wordDict(s, 0, wordSet);
    }

    private static boolean wordDict (String s, int start, Set<String> wordSet) {
        if (start == s.length()) return true;
        else {
            for (int i = Math.min(s.length(), start+max); i >= start + min; -- i) {
                if (wordSet.contains(s.substring(start, i)) && wordDict(s, i, wordSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>(List.of(new String[]{"aaaa", "aaa"}));
        System.out.println(wordDict(s, wordDict));
    }
}

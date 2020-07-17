package wordBreak;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/25
 */
public class Solution3 {
    static int max = 0, min = Integer.MAX_VALUE;
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        boolean[] step = new boolean[s.length()+1];
        step[0] = true;
        for (String s1 : wordDict) {
            wordSet.add(s1);
            max = Math.max(max, s1.length());
            min = Math.min(min, s1.length());
        }

        for (int i = 0; i <= s.length()-min+1; i++) {
            for (int j = i + min; j <= s.length() && j <= i + max; j++) {
                if (step[i]) {
                    if (wordSet.contains(s.substring(i, j))){
                        step[j] = true;
                    }
                }
            }
        }
        return step[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>(List.of(new String[]{"aaa", "aaaa"}));
        System.out.println(wordBreak(s, wordDict));
    }
}

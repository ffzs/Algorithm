package respace;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/9
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        int min = dictionary[0].length(), max = min;
        Set<String> wordSet = new HashSet<>();
        for (String s : dictionary) {
            if (s.length() < min) min = s.length();
            else if (s.length() > max) max = s.length();
            wordSet.add(s);
        }

        int[] dp = new int[sentence.length()+1];
        for (int i = 1; i < sentence.length()+1; i++) {
            dp[i] = dp[i-1] + 1;
            if (i - min >= 0) {
                for (int j = Math.max(i-max, 0); j <= i-min; j++) {
                    if (wordSet.contains(sentence.substring(j, i))) dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[sentence.length()];
    }
}

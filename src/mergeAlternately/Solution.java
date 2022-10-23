package mergeAlternately;

/**
 * @author: ffzs
 * @Date: 2022/10/23 上午11:19
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (n < word1.length()) sb.append(word1.substring(n));
        if (n < word2.length()) sb.append(word2.substring(n));
        return sb.toString();
    }

}

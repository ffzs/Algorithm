package isAnagram;

/**
 * @author: ffzs
 * @Date: 2020/11/22 上午11:09
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        for (char c : cs) {
            counter[c-'a']++;
        }
        for (char c : ts) {
            counter[c-'a']--;
            if (counter[c-'a'] < 0) return false;
        }
        return true;
    }
}

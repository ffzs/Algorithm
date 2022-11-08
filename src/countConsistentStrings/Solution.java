package countConsistentStrings;

/**
 * @author: ffzs
 * @Date: 2022/11/8 上午9:56
 */
public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            allow[allowed.charAt(i) - 'a'] = true;
        }
        int res = 0;
        for (String word : words) {
            if (check(allow, word)) res += 1;
        }
        return res;
    }

    private boolean check (boolean[] allow, String str) {
        for (char c : str.toCharArray()) {
            if (!allow[c - 'a']) return false;
        }
        return true;
    }

}

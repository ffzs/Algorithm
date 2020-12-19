package findTheDifference;

/**
 * @author: ffzs
 * @Date: 2020/12/18 上午8:00
 */

public class Solution {

    public char findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int at = t.charAt(i) - 'a';
            if (counter[at] > 0) counter[at]--;
            else return t.charAt(i);
        }

        return 'a';
    }
}

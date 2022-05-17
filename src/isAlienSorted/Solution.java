package isAlienSorted;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/17 上午8:30
 */
public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int[] reOrdered = new int[26];
        for (int i = 0; i < 26; i++) {
            reOrdered[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(reOrdered, words[i-1], words[i]) > 0) return false;
        }
        return true;
    }

    private int compare (int[] ordered, String a, String b) {
        int ac, bc;
        for (int i = 0; i < Math.min(a.length(), b.length()); ++i) {
            ac = ordered[a.charAt(i) - 'a'];
            bc = ordered[b.charAt(i) - 'a'];
            if (ac != bc) return ac - bc;
        }

        return a.length() - b.length();
    }

}

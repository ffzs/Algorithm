package reversePrefix;

/**
 * @author: ffzs
 * @Date: 2022/2/2 上午8:30
 */
public class Solution {

    public String reversePrefix(String word, char ch) {
        char[] cs = word.toCharArray();
        int r = 0;
        for (int i = 0; i < cs.length; i++) {
            if (ch == cs[i]) {
                r = i;
                break;
            }
        }
        if (r == 0) return word;
        int l = 0;
        while (l < r) {
            char t =cs[l];
            cs[l] = cs[r];
            cs[r] = t;
            r--;
            l++;
        }
        return new String(cs);
    }

}

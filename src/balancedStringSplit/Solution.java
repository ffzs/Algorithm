package balancedStringSplit;

/**
 * @author: ffzs
 * @Date: 2021/9/7 上午6:44
 */

public class Solution {

    public int balancedStringSplit(String s) {
        int l = 0, r = 0;
        int counter = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == 'L') l++;
            else r++;
            if (l == r && l != 0) {
                counter++;
                l = 0;
                r = 0;
            }
        }
        return counter;
    }

}

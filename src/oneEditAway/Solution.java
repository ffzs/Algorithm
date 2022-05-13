package oneEditAway;

/**
 * @author: ffzs
 * @Date: 2022/5/13 上午8:25
 */
public class Solution {

    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;

        if (first.length() < second.length()) return oneEditAway(second, first);

        int pass = 0;
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                ++pass;
                if (first.length() > second.length()) --j;
            }
            if (pass > 1) return false;
            ++i;
            ++j;
        }
        return true;
    }
}

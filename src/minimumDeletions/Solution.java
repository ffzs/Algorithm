package minimumDeletions;

/**
 * @author: ffzs
 * @Date: 2023/3/6 上午6:33
 */
public class Solution {

    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int cb = 0, res = 0;
        for (char c : cs) {
            if (c == 'b') cb += 1;
            else res = Math.min(cb, res + 1);
        }
        return res;
    }

}

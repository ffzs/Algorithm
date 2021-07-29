package titleToNumber;

/**
 * @author: ffzs
 * @Date: 2021/7/30 上午6:58
 * 26进制
 */
public class Solution {

    public int titleToNumber(String columnTitle) {
        char[] cs = columnTitle.toCharArray();

        int res = 0;
        for (char c : cs) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }

}

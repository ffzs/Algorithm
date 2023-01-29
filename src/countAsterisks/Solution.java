package countAsterisks;

/**
 * @author: ffzs
 * @Date: 2023/1/29 上午8:53
 */
public class Solution {

    public int countAsterisks(String s) {
        boolean b = false;
        char[] cs = s.toCharArray();
        int res = 0;
        for (char c : cs) {
            if (c == '|') b ^= true;
            else if (!b && c == '*') res += 1;
        }
        return res;
    }

}

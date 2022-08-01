package generateTheString;

/**
 * @author: ffzs
 * @Date: 2022/8/1 下午12:59
 */
public class Solution {
    static String tmp;
    static {
        tmp  = "zzzzzzzzzz".repeat(50);
    }
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return tmp.substring(0, n-1) + 'a';
        }

        return tmp.substring(0, n);
    }

}

package countDigits;

/**
 * @author: ffzs
 * @Date: 2023/10/26 下午5:01
 */
public class Solution {

    public int countDigits(int num) {
        int v = num, res = 0;
        while (num > 0) {
            int r = num % 10;
            num /= 10;
            if (v % r == 0) res += 1;
        }
        return res;
    }

}

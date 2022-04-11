package countNumbersWithUniqueDigits;

/**
 * @author: ffzs
 * @Date: 2022/4/11 上午8:19
 *
 *
 */
public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 10;

        int res = 10, l = 9;
        for (int i = 0; i < n - 1; i++) {
            l *= 9 - i;
            res += l;
        }
        return res;
    }

}

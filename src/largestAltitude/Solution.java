package largestAltitude;

/**
 * @author: ffzs
 * @Date: 2022/11/19 下午1:03
 */
public class Solution {

    public int largestAltitude(int[] gain) {
        int res = 0, total = 0;
        for (int i : gain) {
            total += i;
            res = Math.max(res, total);
        }
        return res;
    }

}

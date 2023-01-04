package maxValue;

/**
 * @author: ffzs
 * @Date: 2023/1/4 上午10:30
 */
public class Solution {

    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int res = 1;
        maxSum -= n;
        while (maxSum >= r - l + 1) {
            res += 1;
            maxSum -= r - l + 1;
            if (r < n-1) r++;
            if (l > 0) l--;
            if (r == n - 1 && l == 0) return res + maxSum / n;
        }
        return res;
    }

}

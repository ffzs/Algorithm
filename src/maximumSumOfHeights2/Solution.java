package maximumSumOfHeights2;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/1/24 下午7:51
 */
public class Solution {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0L;
        int n = maxHeights.size();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1 || (maxHeights.get(i) > maxHeights.get(i-1) && maxHeights.get(i) >= maxHeights.get(i+1))) {
                res = Math.max(res, center(maxHeights, i));
            }
        }
        return res;
    }

    private long center (List<Integer> arr, int t) {
        long ret = (long)arr.get(t);
        long pre = ret;
        for (int i = t-1; i >= 0; i--) {
            if (arr.get(i) <= pre) {
                ret += arr.get(i);
                pre = arr.get(i);
            } else {
                ret += pre;
            }
        }
        pre = arr.get(t);
        for (int i = t + 1; i < arr.size(); i++) {
            if (arr.get(i) <= pre) {
                ret += arr.get(i);
                pre = arr.get(i);
            } else {
                ret += pre;
            }
        }
        return ret;
    }


}

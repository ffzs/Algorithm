package maximumSumOfHeights;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/21 下午2:00
 */
public class Solution {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = maxHeights.get(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) continue;
            if ((i == 0||nums[i-1]<=nums[i]) && (i == n - 1 || nums[i+1]<=nums[i])){
                res = Math.max(res, helper(nums, i));
            }
        }
        return res;
    }

    private long helper (int[] lst, int t) {
        long ret = lst[t];
        int l = t - 1, r = t + 1;
        int v = lst[t];
        while (l >= 0) {
            v = Math.min(v, lst[l]);
            ret += v;
            l--;
        }
        v = lst[t];
        while (r < lst.length) {
            v = Math.min(v, lst[r]);
            ret += v;
            r++;
        }
        return ret;
    }

}

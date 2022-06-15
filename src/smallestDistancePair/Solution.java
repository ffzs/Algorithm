package smallestDistancePair;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/6/15 下午6:06
 */
public class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = nums[n-1] - nums[0];

        while (l < r) {
            int mid = (r + l) >> 1;
            int cur = counter(nums, mid);
            if (cur < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int counter (int[] nums, int aim) {
        int cnt = 0, l = 0, r = 1, n = nums.length;
        while (r < n) {
            while (nums[r] - nums[l] > aim) l += 1;
            cnt += r - l;
            r += 1;
        }
        return cnt;
    }

}

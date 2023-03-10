package minSubarray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/3/10 下午1:11
 */
public class Solution {

    public int minSubarray(int[] nums, int p) {
        long total = 0;
        int n = nums.length;
        for (int num : nums) {
            total += num;
        }
        int remain = (int)(total % p);
        if (remain == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0, res = n;
        for (int i = 0; i < n; i++) {
            map.put(r, i);
            r = (r + nums[i]) % p;
            int key = (r - remain + p) % p;
            if (map.containsKey(key)) {
                res = Math.min(res, i - map.get(key) + 1);
            }
        }
        return res == n ? -1: res;
    }

}

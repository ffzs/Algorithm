package containsNearbyDuplicate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: ffzs
 * @Date: 2022/1/19 上午8:14
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return false;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < Math.min(n, k); i++) {
            if(!set.add(nums[i])) return true;
        }

        for (int i = k; i < n; i++) {
            if (!set.add(nums[i])) return true;
            set.remove(nums[i-k]);
        }
        return false;
    }

}

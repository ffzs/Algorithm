package findSubarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/3/26 上午8:13
 */
public class Solution {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length-1; i++) {
            int t = nums[i] + nums[i + 1];
            if (!set.add(t)) return true;
        }
        return false;
    }

}

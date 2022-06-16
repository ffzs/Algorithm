package findPairs;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/6/16 下午4:52
 */
public class Solution {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, res = 0;
        for (int l = 0, r = 0; l < n; l++) {
            if (l == 0 || nums[l] != nums[l-1]) {
                while (r < n && (nums[l] + k > nums[r] || l >= r)) r += 1;
                if (r < n && nums[l] + k == nums[r]) res += 1;
            }
        }
        return res;
    }

}

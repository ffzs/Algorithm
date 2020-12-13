package containsDuplicate;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/13 上午10:18
 */

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}

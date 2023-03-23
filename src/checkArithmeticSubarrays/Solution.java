package checkArithmeticSubarrays;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/3/23 上午8:59
 */
public class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(checkArithmetic(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }

        return res;
    }

    private boolean checkArithmetic (int[] nums) {
        if (nums.length <= 1) return false;
        if (nums.length == 2) return true;
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != diff) return false;
        }
        return true;
    }

}

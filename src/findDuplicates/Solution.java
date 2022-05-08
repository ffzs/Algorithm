package findDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/5/8 上午9:01
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t - 1] > 0) {
                nums[t - 1] = - nums[t - 1];
            }
            else res.add(t);
        }
        return res;
    }

}

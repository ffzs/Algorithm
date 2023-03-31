package arithmeticTriplets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/3/31 上午9:08
 */
public class Solution {

    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int three = nums[i] + diff * 2;
            if (three > nums[nums.length-1]) break;
            if (set.contains(nums[i] + diff) && set.contains(three)) res += 1;
        }
        return res;
    }

}

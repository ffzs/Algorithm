package singleNumber2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/10/30 上午7:13
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        for (int num : nums) {
            if (!first.contains(num)) first.add(num);
            else second.add(num);
        }

        int[] res = new int[2];
        for (int i = 0, j = 0; i < n; i++) {
            if (!second.contains(nums[i])) res[j++] = nums[i];
        }
        return res;
    }
}

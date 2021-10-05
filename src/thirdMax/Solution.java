package thirdMax;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/10/6 上午7:02
 */
public class Solution {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        int cnt = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] == nums[i-1]) continue;
            else {
                cnt += 1;
                System.out.println(cnt);
                if (cnt == 3) return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

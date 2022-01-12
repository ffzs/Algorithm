package increasingTriplet;

/**
 * @author: ffzs
 * @Date: 2022/1/12 上午7:52
 */

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        if (n < 3) return false;
        int first = nums[0], second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur <= first) first = cur;
            else if (cur <= second) second = cur;
            else return true;
        }

        return false;
    }

}

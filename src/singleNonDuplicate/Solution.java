package singleNonDuplicate;

/**
 * @author: ffzs
 * @Date: 2022/2/14 上午9:09
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 2;
            mid <<= 1;
            if (nums[mid] == nums[mid + 1]) l = mid + 2;
            else r = mid;
        }
        return nums[l];
    }

}

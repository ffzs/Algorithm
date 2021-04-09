package findMin;

/**
 * @author: ffzs
 * @Date: 2021/4/9 下午2:51
 */
public class Solution {

    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0, r = n - 1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l ++;
                r --;
            }
            else if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }

}

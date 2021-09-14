package findPeakElement;

/**
 * @author: ffzs
 * @Date: 2021/9/15 上午6:46
 */
public class Solution {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length -1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }

}

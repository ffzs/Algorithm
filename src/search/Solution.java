package search;

/**
 * @author: ffzs
 * @Date: 2021/9/6 上午6:53
 */
public class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l == r && nums[l] == target ? l : -1;
    }

}

package searchRange2;

/**
 * @author: ffzs
 * @Date: 2020/12/1 上午7:28
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return findSame(nums, mid);
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        return res;
    }

    private int[] findSame(int[] nums, int mid){
        int left = mid-1, right=mid+1;
        while (left>=0 && nums[left]==nums[mid]) left--;
        while (right<nums.length && nums[right]==nums[mid]) right++;
        return new int[]{left+1, right-1};
    }
}

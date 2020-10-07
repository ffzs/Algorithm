package sortColors;

/**
 * @author: ffzs
 * @Date: 2020/10/7 上午10:05
 */
public class Solution2 {

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<nums.length-1 && nums[left] == 0) left++;
        while (right>=0 && nums[right] == 2) right--;
        int mid = left;

        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            }
            else if (nums[mid] == 2) {
                swap(nums, right--, mid);
            }
            else mid ++;
        }
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

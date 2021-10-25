package nextGreaterElement;

/**
 * @author: ffzs
 * @Date: 2021/10/26 上午7:22
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] indexes = new int[10001];
        for (int i = 0; i < nums2.length; i++) {
            indexes[nums2[i]] = i;
        }

        for (int i = 0; i < nums1.length; i++) {
            int t = nums1[i];
            nums1[i] = find(nums2, indexes[t], t);
        }
        return nums1;
    }
    private int find(int[] nums, int start, int target) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) return nums[i];
        }
        return -1;
    }

}

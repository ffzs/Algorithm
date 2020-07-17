package searchInsert;

public class Solution2 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        if (target > nums[r]) return r+1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}

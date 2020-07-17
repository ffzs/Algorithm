package findKthLargest;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/29
 */
public class Solution2 {
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private static int quickSort (int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int mid = nums[l+r >> 1];
        int left = l, right = r;
        while (true) {
            while (nums[left] < mid) left ++;
            while (nums[right] > mid) right --;
            if (left < right) swap(nums, left++, right--);
            else break;
        }
        if (r-right>=k) return quickSort(nums, right +1, r, k);
        else return quickSort(nums, l, right, k-(r-right));
    }

    private static void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}

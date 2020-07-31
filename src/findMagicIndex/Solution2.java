package findMagicIndex;

/**
 * @author: ffzs
 * @Date: 2020/7/31 上午8:56
 */
public class Solution2 {

    public int findMagicIndex(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    private int dfs (int[] nums, int l, int r) {
        if (l > r) return -1;

        int mid = l + r >>> 1;

        int left = dfs(nums, l, mid-1);

        if (left != -1) return left;
        else if (nums[mid] == mid) return mid;

        return dfs(nums, mid+1, r);
    }
}

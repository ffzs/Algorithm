package countMaxOrSubsets;

/**
 * @author: ffzs
 * @Date: 2022/3/15 上午7:56
 */
public class Solution {

    int res = 0, aim = 0;
    int[] nums;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        for (int num : nums) {
            aim |= num;
        }
        dfs(0, 0);
        return res;
    }

    private void dfs (int num, int idx) {
        if (num == aim) {
            res += (1 << (nums.length - idx));
            return;
        }
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            dfs(num | nums[i], i + 1);
        }
    }

}

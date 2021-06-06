package findTargetSumWays;

/**
 * @author: ffzs
 * @Date: 2021/6/7 上午6:58
 */
public class Solution {

    int[] nums;
    int target, res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int sum){
        if (nums.length == index) {
            if (sum == target) res++;
            return;
        }

        dfs(index + 1, sum + nums[index]);
        dfs(index + 1, sum - nums[index]);
    }
}

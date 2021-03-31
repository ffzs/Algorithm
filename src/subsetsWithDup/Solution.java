package subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/3/31 上午9:53
 */
public class Solution {

    List<List<Integer>> res;
    List<Integer> list;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        list = new ArrayList<>();
        this.nums = nums;

        dfs(-1,0);
        return res;
    }

    private void dfs(int pre, int idx) {
        if (idx >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(pre, idx + 1);
        if (pre + 1 != idx && idx != 0 && nums[idx-1]==nums[idx]) return;
        list.add(nums[idx]);
        dfs(idx, idx + 1);
        list.remove(list.size() - 1);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2,2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}

package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/20 上午7:06
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    private void dfs (List<Integer> list, int start) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(list, i+1);
            list.remove(list.size()-1);
        }
    }
}

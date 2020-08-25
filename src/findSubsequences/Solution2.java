package findSubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/25 上午9:34
 */
public class Solution2 {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>(), Integer.MIN_VALUE);
        return res;
    }
    private void dfs (int i, List<Integer> list, int last) {
        if (i == nums.length) {
            if (list.size() >= 2) res.add(new ArrayList<>(list));
        }
        else {
            // 符合要求添加变量
            if (nums[i] >= last){
                list.add(nums[i]);
                dfs(i+1, list, nums[i]);
                list.remove(list.size()-1);  // list 回溯
            }
            // 未添加变量
            if (nums[i] != last) {
                dfs(i+1, list, last);
            }
        }
    }
}

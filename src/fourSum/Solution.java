package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/5 上午7:06
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, target);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, int start, int target){

        if (target == 0 && list.size() == 4) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (list.size() < 4) {
            for (int i = start; i < nums.length; i++) {
                if (i==start || nums[i] != nums[i-1]) {
                    list.add(nums[i]);
                    target -= nums[i];
                    dfs(nums, list, i+1, target);
                    list.remove(list.size()-1);
                    target += nums[i];
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {-3,-1,0,2,4,5};
        System.out.println(solution.fourSum(nums, 2));
    }
}


package permuteUnique;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: ffzs
 * @Date: 2020/9/18 上午6:54
 */



public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    boolean[] step;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        step = new boolean[nums.length];
        dfs(new ArrayList<>());
        return res;
    }

    private void dfs (List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!step[i] && (i==0 || step[i-1] || nums[i-1] != nums[i])) {
                list.add(nums[i]);
                step[i] = true;
                dfs(list);
                list.remove(list.size()-1);
                step[i] = false;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2};
        System.out.println(solution.permuteUnique(nums));
    }
}

package findSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2020/8/25 上午8:33
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length <= 1) return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            Set<List<Integer>> resTmp = new HashSet<>(res);
            for (List<Integer> re : resTmp) {
                if (nums[i] >= re.get(re.size()-1)) {
                    List<Integer> tmp = new ArrayList<>(re);
                    tmp.add(nums[i]);
                    res.add(tmp);
                }
            }
            if(nums[i] != nums[i-1]){
                for (int j = 0; j < i; j++) {
                    if (nums[j] <= nums[i]) {
                        res.add(List.of(nums[j], nums[i]));
                    }
                }
            }
            else res.add(List.of(nums[i], nums[i]));
        }
        return new ArrayList<>(res);
    }
}

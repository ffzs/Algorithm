package summaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/10 上午8:36
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        int i = 0, j;
        while (i < n) {
            j = i;
            while (j + 1 < n && nums[j] + 1 == nums[j+1]) j++;
            StringBuilder sb = new StringBuilder().append(nums[i]);
            if (i != j) sb.append("->").append(nums[j]);
            res.add(sb.toString());
            i = j + 1;
        }
        return res;
    }
}

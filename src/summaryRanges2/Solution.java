package summaryRanges2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/8/26 上午6:13
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                if (start != nums[i-1]) {
                    res.add(new StringBuilder().append(start).append("->").append(nums[i-1]).toString());
                }
                else {
                    res.add(String.valueOf(start));
                }
                start = nums[i];
            }
        }

        if (start != nums[nums.length-1]) {
            res.add(new StringBuilder().append(start).append("->").append(nums[nums.length-1]).toString());
        }
        else {
            res.add(String.valueOf(start));
        }

        return res;
    }
    
}

package longestConsecutive;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/6
 */
public class Solution2 {
    public int longestConsecutive (int[] nums) {
        if (nums.length <=1) return nums.length;
        Arrays.sort(nums);
        int maxLen = 1;
        int tmp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == tmp + 1){
                count ++;
            }else{
                if (nums[i] != tmp) count = 1;
            }
            maxLen = Math.max(count, maxLen);
            tmp = nums[i];
        }
        return maxLen;
    }
}

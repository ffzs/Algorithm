package isPossible;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/4 上午7:38
 */

public class Solution {
    public boolean isPossible(int[] nums) {
        int min = nums[0];
        int[] count = new int[nums[nums.length-1]-min+1];
        for (int i : nums) {
            count[i-min]++;
        }
        int n = nums.length;
        while (n > 0) {
            int re = split(count);
            if (re < 3) return false;
            else n -= re;
        }
        return true;
    }

    private int split(int[] count) {
        int i = 0, ret = 1;
        while (i < count.length && count[i] == 0) i++;
        int max = count[i];
        count[i++]--;
        while ((i < count.length && count[i] >= max)) {
            ret++;
            max = Math.max(count[i], max);
            count[i]--;
            i++;
        }
        return ret;
    }
}

class Test{
    public static void main(String[] args) {
//        int[] nums = {1,2,3,3,4,5};
        int[] nums = {1,2,3,4,6,7,8,9,10,11};
        Solution solution = new Solution();
        System.out.println(solution.isPossible(nums));
    }
}

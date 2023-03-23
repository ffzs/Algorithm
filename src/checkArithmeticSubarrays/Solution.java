package checkArithmeticSubarrays;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/3/23 上午8:59
 */
public class Solution {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(checkArithmetic(nums, l[i], r[i]));
        }

        return res;
    }

    private boolean checkArithmetic (int[] nums) {
        if (nums.length <= 1) return false;
        if (nums.length == 2) return true;
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != diff) return false;
        }
        return true;
    }


    private boolean checkArithmetic (int[] nums, int l, int r) {
        int maxV = nums[l], minV = nums[l];
        for (int i = l+1; i <= r; i++) {
            maxV = Math.max(maxV, nums[i]);
            minV = Math.min(minV, nums[i]);
        }
        if (maxV == minV) return true;
        int n = r - l;
        if ((maxV - minV) % n != 0) return false;
        int d = (maxV - minV) / n;
        boolean[] t = new boolean[n+1];
        for (int i = l; i <= r; i++) {
            if ((nums[i] - minV) % d != 0) return false;
            int it = (nums[i] - minV)/d;
            if (t[it]) return false;
            t[it] = true;
        }
        return true;
    }

}
